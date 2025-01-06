function openEditModal(taskId, taskDescription, dueDate) {
    console.log("running function");
    document.getElementById(`editTaskId${taskId}`).value = taskId;
    document.getElementById(`editTaskDescription${taskId}`).value = taskDescription;
    document.getElementById(`editDueDate${taskId}`).value = dueDate;
    document.getElementById(`${taskId}`).style.display = 'flex';
}

function closeEditModal(taskId) {
    document.getElementById(`${taskId}`).style.display = 'none';
}