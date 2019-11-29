import 'dart:io';

import 'package:path/path.dart';
import 'package:path_provider/path_provider.dart';
import 'package:sqflite/sqflite.dart';

final todoTable = 'Todo';

class DbProvider {
  static final DbProvider dbProvider = DbProvider();

  Database _database;
  Future<Database> get database async {
    if(_database != null)
      return _database;

    _database = await createDb();
    return _database;
  }

  createDb() async {
    Directory docDir =
      await getApplicationDocumentsDirectory();
    String path = join(docDir.path, "Todo.db");

    var db =
        await openDatabase(path, version: 1, onCreate: initDb);
  }

  void initDb(Database db, int version) async {
    await db.execute("CREATE TABLE $todoTable ("
    "id INTEGER PRIMARY KEY, "
    "description TEXT, "
    "is_done INTEGER "
    ")");
  }
}