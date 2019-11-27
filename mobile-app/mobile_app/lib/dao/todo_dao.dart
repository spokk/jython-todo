import 'package:mobile_app/db/database.dart';
import 'package:mobile_app/model/todo.dart';
import 'package:sqflite/sqflite.dart';

class TodoDao {
  final dbProvider = DbProvider.dbProvider;

  Future<int> createTodo(Todo todo) async {
    final db =
        await dbProvider.database;

    var result = db.insert(todoTable, todo.toDbJson());
    return result;
  }
}