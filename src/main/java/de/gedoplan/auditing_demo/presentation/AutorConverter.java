package de.gedoplan.auditing_demo.presentation;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

import de.gedoplan.auditing_demo.entity.Autor;
import de.gedoplan.auditing_demo.repository.AutorRepository;

/**
 * Converter.
 */
@Named
public class AutorConverter implements Converter {
  
  @Inject 
  AutorRepository ar;

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value)
  {
    if (value == null) {
      return 0;
    }
    Integer integer = Integer.valueOf(value.substring(value.indexOf("id=") + 3, value.length() - 1).trim());
    Autor autor =
        this.ar.find(Long.parseLong(integer.toString()));
    
    return autor;
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value)
  {
    return "" + ((Autor) value).toString();
  }
}