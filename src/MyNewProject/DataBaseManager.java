package MyNewProject;

import MyNewProject.finance.ui.FinanceManagerUI;

import java.sql.*;

public class DataBaseManager {
    //Подключаем SQLite
    private static final String URL = "jdbc:sqlite:finance_manager.db"; //Создается файл базы данных
    private static final String DB_URL = "jdbc:sqlite:finance_manager.db";

    public static void main(String[] args) {
        createTables();
        manageFinances();
        new FinanceManagerUI();
    }

    private static void manageFinances() {
        addExpense("Eat", 500, "2025-02-01");
        addExpense("Transport", 250, "2025-01-01");

        addIncome("Freelance", 2000, "2025-02-01");
        addIncome("Salary", 3000, "2025-01-15");

        System.out.println("\n All expenses");
        getExpenses();

        System.out.println("\n All income");
        getIncome();
    }

    private static void addExpense(String category, double amount, String date) {
        String sql = "INSERT INTO expenses (category, amount, date) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category);
            pstmt.setDouble(2, amount);
            pstmt.setString(3, date);
            pstmt.executeUpdate();

            System.out.println("✅ Expense addded: " + category + " - " + amount);
        } catch (SQLException e) {
            System.err.println("Error when adding an expense: " + e.getMessage());
        }
    }

    private static void addIncome(String source, double amount, String date) {
        String sql = "INSERT INTO income (source, amount, date) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, source);
            pstmt.setDouble(2, amount);
            pstmt.setString(3, date);
            pstmt.executeUpdate();
            System.out.println("Added revenue: " + source + "-" + amount);
        } catch (SQLException e) {
            System.err.println("Error when adding income: " + e.getMessage());
        }
    }

    private static void getExpenses(){
        String sql = "SELECT * FROM expenses";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " +
                                   rs.getString("category") + " - " +
                                   rs.getDouble("amount") + " руб. (" +
                                   rs.getString("date") + ")");
            }

        } catch (SQLException e) {
            System.err.println("Error when receiving expenses: " + e.getMessage());
        }
    }

    private static void getIncome() {
        String sql = "SELECT * FROM income";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " +
                                   rs.getString("source") + " - " +
                                   rs.getDouble("amount") + " руб. (" +
                                   rs.getString("date") + ")");
            }

        } catch (SQLException e) {
            System.err.println("Error when receiving incomeL " + e.getMessage());
        }
    }

    public static void createTables() {

        //Создаем соединение с базой данных
        try (Connection conn = DriverManager.getConnection(URL);//Подключает SQLite
             Statement stmt = conn.createStatement()) { //Выполняет SQLite запросы
            //Создаем таблицы
            //CREATE TABLE IF NOT EXISTS transactions — создает таблицу, если её нет
            // id INTEGER PRIMARY KEY AUTOINCREMENT — автоинкрементный уникальный ID
            //type TEXT CHECK(type IN ('income', 'expense')) — ограничение на "доход" или "расход"
            //FOREIGN KEY(account_id) REFERENCES accounts(id) — связь с таблицей accounts
            String createTransactions = """
                    CREATE TABLE IF NOT EXISTS transactions (
                                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                                        amount REAL NOT NULL,
                                        category TEXT NOT NULL,
                                        type TEXT CHECK(type IN ('income', 'expense')) NOT NULL,
                                        date TEXT NOT NULL,
                                        account_id INTEGER,
                                        FOREIGN KEY(account_id) REFERENCES accounts(id)
                                    );""";
            String createAccounts = """
                    CREATE TABLE IF NOT EXISTS accounts (
                                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                                        name TEXT NOT NULL,
                                        balance REAL NOT NULL,
                                        currency TEXT NOT NULL
                                    );
                    """;
            String createCategories = """
                    CREATE TABLE IF NOT EXISTS categories (
                                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                                        name TEXT NOT NULL,
                                        type TEXT CHECK(type IN ('income', 'expense')) NOT NULL
                                    );""";
            String createReminders = """
                    CREATE TABLE IF NOT EXISTS reminders (
                                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                                        message TEXT NOT NULL,
                                        date TEXT NOT NULL
                                    );""";
            String createExpenses = """
    CREATE TABLE IF NOT EXISTS expenses (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        category TEXT NOT NULL,
        amount REAL NOT NULL,
        date TEXT NOT NULL
    );""";

            String createIncome = """
    CREATE TABLE IF NOT EXISTS income (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        source TEXT NOT NULL,
        amount REAL NOT NULL,
        date TEXT NOT NULL
    );""";

            stmt.execute(createExpenses);
            stmt.execute(createIncome);
            stmt.execute(createTransactions);
            stmt.execute(createAccounts);
            stmt.execute(createCategories);
            stmt.execute(createReminders);

            System.out.println("The database has been successfully created!");

        } catch (SQLException e) {
            System.err.println("Error creating database: " + e.getMessage());
        }
    }

    public static void addTransaction(double amount, String category, String type) {

    }
}