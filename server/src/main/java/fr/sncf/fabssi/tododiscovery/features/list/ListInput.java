package fr.sncf.fabssi.tododiscovery.features.list;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListInput {
   @NotNull
   private String label;
}
