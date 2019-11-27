import 'package:flutter/material.dart';
import 'package:mobile_app/bloc/todo_bloc.dart';
import 'package:mobile_app/model/todo.dart';

class HomePage extends StatelessWidget {
  HomePage({Key key, this.title}) : super(key: key);

  final todoBloc = TodoBloc();
  final String title;
  final DismissDirection _dismissDirection = DismissDirection.horizontal;


//  TODO: implement UI

  Widget getTodoWidget() {
    return StreamBuilder(
      stream: todoBloc.todos,
      builder: (BuildContext context,  AsyncSnapshot<List<Todo>> snapshot) {
        return getTodoCardWidget(snapshot);
      },
    );
  }

  Widget getTodoCardWidget(AsyncSnapshot<List<Todo>> snapshot) {
    if(snapshot.hasData) {
      return snapshot.data.length != 0 ? ListView.builder(itemCount: snapshot.data.length,
                                                          itemBuilder: (context, itemPosition) {
                                                             Todo todo = snapshot.data[itemPosition];
                                                             final Widget dissmisibleCard = new Dismissible(
                                                               background: Container(
                                                                 child: Padding(
                                                                   padding: EdgeInsets.only(left: 10),
                                                                   child: Align(
                                                                     alignment: Alignment.centerLeft,
                                                                     child: Text(
                                                                       "Deleting",
                                                                       style: TextStyle(color: Colors.white),
                                                                     ),
                                                                   ),
                                                                 ),
                                                                 color: Colors.redAccent,
                                                               ),
                                                               onDismissed: (direction) {
                                                                 todoBloc.deleteItem(todo.id);
                                                               },
                                                               direction: _dismissDirection,
                                                               key: new ObjectKey(todo),
                                                               child: Card(
                                                                 shape: RoundedRectangleBorder(
                                                                   side: BorderSide(color: Colors.grey[200], width: 0.5),
                                                                   borderRadius: BorderRadius.circular(5),
                                                                 ),
                                                                 color: Colors.white,
                                                                 child: ListTile(
                                                                    leading: InkWell(
                                                                      onTap: () {
                                                                        todo.isDone = !todo.isDone;
                                                                        todoBloc.updateItem(todo);
                                                                      },
                                                                    ),
                                                                 ),
                                                               ),
                                                             );
                                                          }) : Container (
        child: Center(
          child: //NoToDoMessageWidget,
        ),
      )
    }
  }
}