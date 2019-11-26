import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'TODO',
      theme: ThemeData(
        primarySwatch: Colors.deepOrange,
      ),
      home: new TodoList()
    );
  }
}

class TodoList extends StatefulWidget {
  @override
  createState () => new TodoListState();
}

class TodoListState extends State<TodoList> {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text('Todo List'),
      ),
    );
  }
}
