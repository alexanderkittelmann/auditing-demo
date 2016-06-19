package presentation;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import entity.Autor;
import repository.AutorRepository;

@Named
@RequestScoped
public class AutorPresenter {

  @Inject
  AutorRepository autorRepository;

  @Inject
  Autor neuerAutor;

  public void newAutor()
  {    
    this.autorRepository.persist(neuerAutor);
  }


   public String saveAutor(Autor autor)
   {
   autorRepository.getAendernAutor().setId(autor.getId());
   autorRepository.getAendernAutor().setNachname(autor.getNachname());
   autorRepository.getAendernAutor().setVorname(autor.getVorname());
   return "autorAendern.xhtml";
   }

  public Autor getNeuerAutor()
  {
    return neuerAutor;
  }

  public void setNeuerAutor(Autor neuerAutor)
  {
    this.neuerAutor = neuerAutor;
  }

  public List<Autor> findeAlleAutoren()
  {
    return this.autorRepository.findAll();
  }

  public void autorAktualisieren()
  {
    this.autorRepository.merge();
  }

  public void autorLoeschen(Autor Autor)
  {
    this.autorRepository.remove(Autor);
  }

  public AutorRepository getAutorRepository()
  {
    return autorRepository;
  }

  public void setAutorRepository(AutorRepository AutorRepository)
  {
    this.autorRepository = AutorRepository;
  }

}
