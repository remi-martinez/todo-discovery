package fr.sncf.fabssi.tododiscovery.features.list;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Builder
public class ListServiceInput {
    @NotNull private String label;
}
