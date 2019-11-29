import 'package:mobile_app/dao/todo_dao.dart';
import 'package:mobile_app/model/todo.dart';

class TodoRepository {
  final todoDao = TodoDao();

  Future getAllItems({String query}) => todoDao.getTodoItems(query: query);
  Future insertItem(Todo todo) => todoDao.createTodo(todo);
  Future updateItem(Todo todo) => todoDao.updateItems(todo);
  Future deleteItemById(int id) => todoDao.deleteItem(id);
  Future deleteAllItems() => todoDao.deleteAllItems();
}