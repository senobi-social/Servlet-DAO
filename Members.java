package bean;

public class Members implements java.io.Serializable {

  private int id;
  private String name;
  private String gender;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getGender() {
    return gender;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

}
