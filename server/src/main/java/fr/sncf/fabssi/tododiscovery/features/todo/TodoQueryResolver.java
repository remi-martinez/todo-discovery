package fr.sncf.fabssi.tododiscovery.features.todo;

import com.sun.istack.NotNull;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TodoQueryResolver implements GraphQLQueryResolver {

    private TodoService todoService;

    @Autowired
    public TodoQueryResolver(TodoService todoService){
        this.todoService = todoService;
    }

    @NotNull
    public Todo todo(long id){
        return todoService.findOrThrow(id);
    }

    @NotNull
    public List<Todo> todos(){
        return todoService.findAll();
    }

    @NotNull
    public List<Todo> findAllByList_Id(long id) { return todoService.findAllByList_Id(id); }
}
