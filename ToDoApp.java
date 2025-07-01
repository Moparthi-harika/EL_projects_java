import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoApp extends JFrame {
    // Model holding the list of tasks
    private DefaultListModel<String> taskListModel;
    // Component that displays tasks
    private JList<String> taskList;
    // Input field to enter a new task
    private JTextField taskField;
    // Buttons for adding and deleting tasks
    private JButton addButton, deleteButton;

    public ToDoApp() {
        // Set up the frame
        setTitle("To-Do List Application");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen

        // Initialize the list model and JList
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        // Add scroll functionality so long lists can scroll
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Initialize the text field and buttons
        taskField = new JTextField(20);
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Task");

        // Create a panel to hold the input field and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.add(taskField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        // Set the layout for the frame and add components
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        // Event Listener: Add a new task when "Add Task" is clicked
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Trim to avoid adding empty tasks with only spaces
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    taskListModel.addElement(task);
                    taskField.setText(""); // clear input after adding
                }
            }
        });

        // Event Listener: Delete the selected task when "Delete Task" is clicked
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskListModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(ToDoApp.this, 
                        "Please select a task to delete.", 
                        "No Task Selected", 
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        // Run the GUI code on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoApp().setVisible(true);
            }
        });
    }
}