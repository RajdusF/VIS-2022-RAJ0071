package DataLayer.Database;

import java.sql.*;

public class Gateway {
    String connectionUrl = "jdbc:sqlserver://dbsys.cs.vsb.cz\\STUDENT;database=RAJ0071;user=raj0071;password=P13pmu7382g7fMFq;encrypt=false;trustServerCertificate=false;loginTimeout=30;";

    public void showVehicles() {
        try {
            Connection connection = DriverManager.getConnection(this.connectionUrl);

            try {
                Statement statement = connection.createStatement();

                try {
                    String selectSql = "SELECT * FROM Vehicle";
                    ResultSet rs = statement.executeQuery(selectSql);

                    System.out.println("Selecting table in given database...");
                    System.out.println("id:\ttitle:\t\ttype:\tselling price:\tproduction price:\t");
                    while(rs.next())
                        System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6));

                } catch (Throwable var8) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var9) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var10) {
            var10.printStackTrace();
        }
    }

    public void showUsers() {
        try {
            Connection connection = DriverManager.getConnection(this.connectionUrl);

            try {
                Statement statement = connection.createStatement();

                try {
                    String selectSql = "SELECT * FROM Users";
                    ResultSet rs = statement.executeQuery(selectSql);

                    System.out.println("Selecting table in given database...");
                    System.out.println("id:\tname:\tsurname:\t");
                    while(rs.next())
                        System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t\t" + rs.getString(3) );

                } catch (Throwable var8) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var9) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var10) {
            var10.printStackTrace();
        }
    }

    public void addUser(String name, String surname) {
        try {
            Connection connection = DriverManager.getConnection(this.connectionUrl);

            try {
                Statement statement = connection.createStatement();

                try {
                    String insertSql = "INSERT INTO Users (name, surname) VALUES (?,?)";

                    PreparedStatement prepStmt = connection.prepareStatement(insertSql);
                    prepStmt.setString(1, name );
                    prepStmt.setString(2, surname );

                    prepStmt.execute();

                } catch (Throwable var8) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var9) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var10) {
            var10.printStackTrace();
        }
    }

    public void addVehicle(String title, String type, String sellingPrice, String productionPrice) {
        try {
            Connection connection = DriverManager.getConnection(this.connectionUrl);

            try {
                Statement statement = connection.createStatement();

                try {
                    String insertSql = "INSERT INTO Vehicle (title, type, selling_price, production_price) VALUES (?, ?, ?, ?)";

                    PreparedStatement prepStmt = connection.prepareStatement(insertSql);
                    prepStmt.setString(1, title );
                    prepStmt.setString(2, type );
                    prepStmt.setString(3, sellingPrice );
                    prepStmt.setString(4, productionPrice );

                    prepStmt.execute();

                } catch (Throwable var8) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var9) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var10) {
            var10.printStackTrace();
        }
    }

    public void findVehicle(String toFind) {
        try {
            Connection connection = DriverManager.getConnection(this.connectionUrl);

            try {
                Statement statement = connection.createStatement();

                try {
                    String selectSql = "SELECT * FROM Vehicle WHERE title LIKE ?";

                    PreparedStatement prepStmt = connection.prepareStatement(selectSql);
                    prepStmt.setString(1, "%" + toFind + "%");

                    ResultSet rs = prepStmt.executeQuery();

                    System.out.println("Selecting table in given database...");
                    System.out.println("id:\ttitle\tselling price\tproduction price\t");
                    while(rs.next())
                        System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t\t" + rs.getString(3) + "\t\t" + rs.getString(5) + "\t\t" + rs.getString(6));

                } catch (Throwable var8) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var9) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var10) {
            var10.printStackTrace();
        }
    }

    public void increasePrice(String percent) {
        try {
            Connection connection = DriverManager.getConnection(this.connectionUrl);

            try {
                Statement statement = connection.createStatement();

                try {
                    String insertSql = "UPDATE Vehicle SET selling_price = selling_price * ?";

                    PreparedStatement prepStmt = connection.prepareStatement(insertSql);
                    prepStmt.setString(1, percent);

                    prepStmt.executeUpdate();

                } catch (Throwable var8) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var9) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var10) {
            var10.printStackTrace();
        }
    }

    public void increasePrice(String id, String percent) {
        try {
            Connection connection = DriverManager.getConnection(this.connectionUrl);

            try {
                Statement statement = connection.createStatement();

                try {
                    String insertSql = "UPDATE Vehicle SET selling_price = selling_price * ? WHERE id_number = ?";

                    PreparedStatement prepStmt = connection.prepareStatement(insertSql);
                    prepStmt.setString(1, percent);
                    prepStmt.setString(2, id);

                    prepStmt.executeUpdate();

                } catch (Throwable var8) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var9) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException var10) {
            var10.printStackTrace();
        }
    }
}
