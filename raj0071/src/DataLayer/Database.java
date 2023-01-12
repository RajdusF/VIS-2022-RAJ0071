package DataLayer;

import java.sql.*;
import java.util.ArrayList;

public class Database {
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

    public void showUsers() {
        try {
            Connection connection = DriverManager.getConnection(this.connectionUrl);

            try {
                Statement statement = connection.createStatement();

                try {
                    String selectSql = "SELECT * FROM Users";
                    ResultSet rs = statement.executeQuery(selectSql);

                    System.out.println("Selecting table in given database...");
                    System.out.println("id:\tname\tsurname\t");
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

    public void addUser(String name, String surName) {
        try {
            Connection connection = DriverManager.getConnection(this.connectionUrl);

            try {
                Statement statement = connection.createStatement();

                try {
                    String insertSql = "INSERT INTO Users (name, surname) VALUES ('" + name + "','" + surName + "')";
                    statement.executeUpdate(insertSql);

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
                    String insertSql = "INSERT INTO Vehicle (title, type, selling_price, production_price) VALUES " +
                            "('" + title + "','" + type + "'," + sellingPrice + "," + productionPrice + ")";
                    statement.executeUpdate(insertSql);

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
                    String selectSql = "SELECT * FROM Vehicle WHERE title LIKE '%" + toFind + "%'";
                    ResultSet rs = statement.executeQuery(selectSql);

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
                    String insertSql = "UPDATE Vehicle SET selling_price = selling_price * '" + percent + "'";

                    statement.executeUpdate(insertSql);

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
                    String insertSql = "UPDATE Vehicle SET selling_price = selling_price * '" + percent + "' WHERE id_number = " + id;

                    statement.executeUpdate(insertSql);

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
