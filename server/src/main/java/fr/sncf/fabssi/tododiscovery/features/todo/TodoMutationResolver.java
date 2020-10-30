package fr.sncf.fabssi.tododiscovery.features.todo;

import com.sun.istack.NotNull;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoMutationResolver implements GraphQLMutationResolver {

    private final TodoService todoService;

    @Autowired
    public TodoMutationResolver(TodoService todoService){
        this.todoService = todoService;
    }

    @NotNull
    public Todo createTodo(@NotNull TodoInput todoInput) {
        TodoServiceInput todoServiceInput = TodoServiceInput.builder()
                .done(todoInput.isDone())
                .dueDate(todoInput.getDueDate())
                .label(todoInput.getLabel())
                .listId(todoInput.getListId())
                .build();

        return todoService.createTodo(todoServiceInput);
    }

    @NotNull
    public Todo updateTodo(@NotNull TodoInput todoInput, long id){
        TodoServiceInput todoServiceInput = TodoServiceInput.builder()
                .done(todoInput.isDone())
                .listId(todoInput.getListId())
                .dueDate(todoInput.getDueDate())
                .label(todoInput.getLabel())
                .build();

        return todoService.updateTodo(todoServiceInput, id);
    }

    @NotNull
    public Todo deleteTodo(long id){
        Todo deletedTodo = todoService.findOrThrow(id);
        todoService.deleteTodo(id);
        return deletedTodo;
    }

}
