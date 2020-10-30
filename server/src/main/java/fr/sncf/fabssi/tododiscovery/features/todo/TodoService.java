package fr.sncf.fabssi.tododiscovery.features.todo;

import com.sun.istack.NotNull;
import fr.sncf.fabssi.tododiscovery.features.list.ListInput;
import fr.sncf.fabssi.tododiscovery.features.list.ListService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepo;
    private ListService listService;

    @Autowired
    public TodoService(TodoRepository todoRepo, ListService listService){
        this.todoRepo = todoRepo;
        this.listService = listService;
    }

    public List<Todo> findAll() {
        return todoRepo.findAll();
    }

    @NotNull
    public Todo findOrThrow(long id) {
        return todoRepo.findById(id).orElseThrow(() -> new RuntimeException("To-do inexistant"));
    }

    public List<Todo> findAllByList_Id(long id) {
        return todoRepo.findAllByList_Id(id);
    }

    @NotNull
    public Todo createTodo(@NotNull TodoServiceInput todoInput) {
        Todo newTodo = Todo.builder()
                .creationDate(LocalDateTime.now())
                .done(todoInput.isDone())
                .dueDate(todoInput.getDueDate())
                .label(todoInput.getLabel())
                .list(listService.findOrThrow(todoInput.getListId()))
                .build();

        return todoRepo.save(newTodo);
    }
    @NotNull
    public Todo updateTodo(@NotNull TodoServiceInput todoInput, long id) {
        Todo updatedTodo = findOrThrow(id);

        updatedTodo.setLabel(todoInput.getLabel());
        updatedTodo.setDueDate(todoInput.getDueDate());
        updatedTodo.setDone(todoInput.isDone());
        updatedTodo.setList(listService.findOrThrow(todoInput.getListId()));

        return todoRepo.save(updatedTodo);
    }

    @NotNull
    public Todo deleteTodo(long id) {
        Todo deletedTodo = findOrThrow(id);
        todoRepo.delete(deletedTodo);
        return deletedTodo;
    }
}
