package Test_To_Do_List;

import javax.swing.*;
import java.awt.*;

public class ToDoList {
    private JFrame frame;
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskInput;
    private JButton addButton, removeButton, clearButton;

    public ToDoList() {
        // Настройка главного окна
        frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        // Красивый заголовок
        JLabel titleLabel = new JLabel("📌 My To-Do List", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Модель списка задач
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Панель для ввода задач
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        taskInput = new JTextField();
        taskInput.setFont(new Font("Arial", Font.PLAIN, 16));
        inputPanel.add(taskInput, BorderLayout.CENTER);

        // Кнопка "Добавить"
        addButton = new JButton("➕ Добавить");
        styleButton(addButton);
        addButton.addActionListener(e -> addTask());
        inputPanel.add(addButton, BorderLayout.EAST);

        frame.add(inputPanel, BorderLayout.SOUTH);

        // Панель с кнопками
        JPanel buttonPanel = new JPanel();
        removeButton = new JButton("❌ Удалить");
        styleButton(removeButton);
        removeButton.addActionListener(e -> removeTask());

        clearButton = new JButton("🗑 Очистить всё");
        styleButton(clearButton);
        clearButton.addActionListener(e -> clearTasks());

        buttonPanel.add(removeButton);
        buttonPanel.add(clearButton);
        frame.add(buttonPanel, BorderLayout.NORTH);

        // Отображение окна
        frame.setVisible(true);
    }

    // Стилизация кнопок
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBackground(new Color(17, 31, 204));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    // Добавление задачи
    private void addTask() {
        String task = taskInput.getText().trim();
        if (!task.isEmpty()) {
            listModel.addElement("🔹 " + task);
            taskInput.setText("");
        }
    }

    // Удаление выбранной задачи
    private void removeTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
        }
    }

    // Очистка списка задач
    private void clearTasks() {
        listModel.clear();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoList::new);
    }
}

