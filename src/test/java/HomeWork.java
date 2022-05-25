import java.sql.*;

public class HomeWork {

        private static final String USER_NAME = "JDiLRjOSSC";
        private static final String DATABASE_NAME = "JDiLRjOSSC";
        private static final String PASSWORD = "TTWcgbW4De";
        private static final String PORT = "3306";
        private static final String SERVER = "remotemysql.com";

        public static void main(String[] args) throws SQLException {
            Connection con = DriverManager.getConnection("jdbc:mysql://"+SERVER+":"+PORT, USER_NAME, PASSWORD);

//            createTable(con);
//            getTableContent(con);
            insertUser(con,"bbb",5,"xxx");
            insertUser(con,"aaa",2,"poodle");
            insertUser(con,"rex",3,"bulldog");


//        deleteUserByName(con, "Avi");
//        updateUserName(con,123, "Avi");
//        getTableContent(con);
            con.close();
        }

        private static void createTable(Connection con) throws SQLException {
            String statementToExecute = "CREATE TABLE " + DATABASE_NAME + ".`dogs`(`name` VARCHAR (40) NOT NULL,`age` INT NOT NULL,`breed` VARCHAR (30) NOT NULL)";
            con.createStatement().execute(statementToExecute);
        }

        private static void insertUser(Connection con,  String name, int id,String breed) throws SQLException {
            String statementToExecute = "INSERT INTO " + DATABASE_NAME + ".dogs (`name`, `age` ,'breed') VALUES ('" + name + "', 'age','" + breed + "');";
            con.createStatement().execute(statementToExecute);
        }

        private static void getTableContent(Connection con) throws SQLException {
            String statementToExecute = "SELECT * FROM " + DATABASE_NAME + ".dogs;";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(statementToExecute);
            while(rs.next()){
                //Retrieve by column name

                String name = rs.getString("name");
                int age  = rs.getInt("age");
                String breed = rs.getString("breed");

                //Display values
                System.out.print("NAME: " + name);
                System.out.print(", AGE: " + age);
                System.out.print(", BREED: " + breed);
            }
            rs.close();
        }

    }

