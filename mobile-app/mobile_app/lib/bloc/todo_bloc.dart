import 'dart:async';

import 'package:mobile_app/model/todo.dart';
import 'package:mobile_app/repository/todo_repository.dart';

class TodoBloc {
  final _todoRepository = TodoRepository();
  final _todoController = StreamController<List<Todo>>.broadcast();

  get todos => _todoController.stream;

  TodoBloc() {
    getItems();
  }

  getItems({String query}) async {
    _todoController.sink.add(await _todoRepository.getAllItems(query: query));
  }

  addItem(Todo todo) async {
    await _todoRepository.insertItem(todo);
    getItems();
  }

  updateItem(Todo todo) async {
    await _todoRepository.updateItem(todo);
    getItems();
  }

  deleteItem(int id) async {
    _todoRepository.deleteItemById(id);
    getItems();
  }

  dispose() {
    _todoController.close();
  }
}