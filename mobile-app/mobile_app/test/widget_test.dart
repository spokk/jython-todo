// This is a basic Flutter widget test.
//
// To perform an interaction with a widget in your test, use the WidgetTester
// utility that Flutter provides. For example, you can send tap and scroll
// gestures. You can also use WidgetTester to find child widgets in the widget
// tree, read text, and verify that the values of widget properties are correct.

import 'package:flutter/material.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:mockito/mockito.dart';

import 'package:mobile_app/main.dart';

class MockNavigatorObserver extends NavigatorObserver {
  OnObservation onPushed;
  OnObservation onPopped;
  OnObservation onRemoved;
  OnObservation onReplaced;

  @override
  void didPush(Route<dynamic> route, Route<dynamic> previousRoute) {
    if (onPushed != null) {
      onPushed(route, previousRoute);
    }
  }

  @override
  void didPop(Route<dynamic> route, Route<dynamic> previousRoute) {
    if (onPopped != null) {
      onPopped(route, previousRoute);
    }
  }

  @override
  void didRemove(Route<dynamic> route, Route<dynamic> previousRoute) {
    if (onRemoved != null)
      onRemoved(route, previousRoute);
  }

  @override
  void didReplace({ Route<dynamic> oldRoute, Route<dynamic> newRoute }) {
    if (onReplaced != null)
      onReplaced(newRoute, oldRoute);
  }
}

void main() {
  testWidgets('Button is present and triggers navigation after tapped', (WidgetTester tester) async {
    final mockObserver = MockNavigatorObserver();
    await tester.pumpWidget(
      MaterialApp(
        home: TodoList(),
        navigatorObservers: [mockObserver],
      ),
    );

    expect(find.byType(FloatingActionButton), findsOneWidget);

    await tester.tap(find.byType(FloatingActionButton));
    await tester.pumpAndSettle();

    verify(mockObserver.didPush(typed(any), typed(any)));

    expect(find.byType(MaterialPageRoute), findsOneWidget)

    // Verify that our counter has incremented.
    // expect(find.text('Item 0'), findsNothing);
    // expect(find.text('Item 1'), findsOneWidget);
  });
}
