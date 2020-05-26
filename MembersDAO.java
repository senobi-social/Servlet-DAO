package dao;

import bean.Members;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class MembersDAO extends DAO {

  // 検索機能をもつメソッド
  public List<Members> search(String keyword) throws Exception {

    // ResultSetオブジェクトを詰め替える
    // リストの型はBeanであるMembers
    List<Members> list = new ArrayList<>();

    // DAOクラスのgetConnectionメソッドを使ってDBに接続
    // データソースの取得はDAOクラスで行っている
    Connection con = getConnection();

    // SQL文の準備
    PreparedStatement st = con.prepareStatement(
      "select * from temperature_members where name like ?");

      // プレースホルダーの定義
      st.setString(1, "%" + keyword + "%");

      // SQL文の実行
      ResultSet rs = st.executeQuery();

      // 検索結果を表示する
      while (rs.next()) {

        Members m = new Members();
        m.setId(rs.getInt("id"));
        m.setName(rs.getString("name"));
        m.setGender(rs.getString("gender"));
        list.add(m);
      }

      // データベースの接続を切断
      st.close();
      con.close();

      // このリストを返す
      return list;
  }

  // 追加機能をもつメソッド
  public int insert(Members member) throws Exception {

    Connection con = getConnection();

    PreparedStatement st = con.prepareStatement(
    "insert into temperature_members values(?, ?, ?, null)");

    st.setInt(1, member.getId());
    st.setString(2, member.getName());
    st.setString(3, member.getGender());

    int line = st.executeUpdate();

    st.close();
    con.close();

    return line;

  }
}
