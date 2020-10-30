package fr.sncf.fabssi.tododiscovery.features.list;

import com.sun.istack.NotNull;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListQueryResolver implements GraphQLQueryResolver {

    private ListService listService;

    @Autowired
    public ListQueryResolver(ListService listService) { this.listService = listService; }

    @NotNull
    public List list(long id) { return listService.findOrThrow(id); }

    @NotNull
    public java.util.List<List> lists(){ return listService.findAll(); }
}