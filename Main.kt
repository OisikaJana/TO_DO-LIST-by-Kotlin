fun main() {
    val tasks = mutableListOf<String>()
    val completedTasks = mutableListOf<Boolean>()

    while (true) {
        println("\n--- To-Do List ---")
        println("1. Add Task")
        println("2. View Tasks")
        println("3. Mark Task as Complete")
        println("4. Delete Task")
        println("5. Exit")
        print("Choose an option: ")

        when (readLine()?.toIntOrNull()) {
            1 -> addTask(tasks, completedTasks)
            2 -> viewTasks(tasks, completedTasks)
            3 -> markTaskAsComplete(tasks, completedTasks)
            4 -> deleteTask(tasks, completedTasks)
            5 -> {
                println("Exiting...")
                break
            }
            else -> println("Invalid option. Please try again.")
        }
    }
}

fun addTask(tasks: MutableList<String>, completedTasks: MutableList<Boolean>) {
    print("Enter the task: ")
    val task = readLine().orEmpty()
    tasks.add(task)
    completedTasks.add(false)
    println("Task added.")
}

fun viewTasks(tasks: List<String>, completedTasks: List<Boolean>) {
    if (tasks.isEmpty()) {
        println("No tasks available.")
    } else {
        println("\n--- Task List ---")
        tasks.forEachIndexed { index, task ->
            val status = if (completedTasks[index]) "Completed" else "Incomplete"
            println("${index + 1}. $task - $status")
        }
    }
}

fun markTaskAsComplete(tasks: MutableList<String>, completedTasks: MutableList<Boolean>) {
    if (tasks.isEmpty()) {
        println("No tasks available to mark.")
        return
    }
    print("Enter task number to mark as complete: ")
    val taskNumber = readLine()?.toIntOrNull()
    if (taskNumber != null && taskNumber in 1..tasks.size) {
        completedTasks[taskNumber - 1] = true
        println("Task marked as complete.")
    } else {
        println("Invalid task number.")
    }
}

fun deleteTask(tasks: MutableList<String>, completedTasks: MutableList<Boolean>) {
    if (tasks.isEmpty()) {
        println("No tasks available to delete.")
        return
    }
    print("Enter task number to delete: ")
    val taskNumber = readLine()?.toIntOrNull()
    if (taskNumber != null && taskNumber in 1..tasks.size) {
        tasks.removeAt(taskNumber - 1)
        completedTasks.removeAt(taskNumber - 1)
        println("Task deleted.")
    } else {
        println("Invalid task number.")
    }
}
