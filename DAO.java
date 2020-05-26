package dao;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DAO {

  // データソースを保存する変数を用意
  // このデータソースを使い回す
  // staticにしているのは１つのデータソースをサブクラスとも共有するため
  static DataSource ds;

  // データベースへの接続を確立
  public Connection getConnection() throws Exception {

    // データソースが未初期化のときデータソースを取得する
    if(ds == null) {

      // InitialContextはデータソース取得のための窓口
      InitialContext ic = new InitialContext();

      ds = (DataSource)ic.lookup("java:/comp/env/jdbc/book");

    }

    return ds.getConnection();

  }
}
