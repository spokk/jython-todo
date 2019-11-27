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

  Future<List<Todo>> getTodoItems({List<String> col, String query}) async {
    final db =
        await dbProvider.database;

    List<Map<String, dynamic>> result;
    if(query != null) {
      if(query.isNotEmpty)
        result =
            await db.query(todoTable,
            columns: col,
            where: 'description LIKE ?',
            whereArgs: ["%query"]);
    } else {
      result =
          await db.query(todoTable, columns: col);
    }

    List<Todo> items =
          result.isNotEmpty ? result.map((item) => Todo.fromDbJson(item)).toList() : [];
    
    return items;
  }
}