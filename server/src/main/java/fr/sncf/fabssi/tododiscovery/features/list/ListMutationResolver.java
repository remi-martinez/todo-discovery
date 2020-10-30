package fr.sncf.fabssi.tododiscovery.features.list;

import com.sun.istack.NotNull;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListMutationResolver implements GraphQLMutationResolver {

    private final ListService listService;

    @Autowired
    public ListMutationResolver(ListService listService){
        this.listService = listService;
    }

    @NotNull
    public List createList(@NotNull ListInput listInput){
        ListServiceInput listServiceInput = ListServiceInput.builder()
                .label(listInput.getLabel())
                .build();

        return listService.createList(listServiceInput);
    }

    @NotNull
    public List updateList(@NotNull ListInput listInput, long id){
        ListServiceInput listServiceInput = ListServiceInput.builder()
                .label(listInput.getLabel())
                .build();

        return listService.updateList(listServiceInput, id);
    }

    @NotNull
    public List deleteList(long id){
        List deletedList = listService.findOrThrow(id);
        listService.deleteList(id);
        return deletedList;
    }

}
