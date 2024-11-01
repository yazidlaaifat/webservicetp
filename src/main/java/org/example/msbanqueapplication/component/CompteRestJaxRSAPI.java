package org.example.msbanqueapplication.component;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.msbanqueapplication.entities.Compte;
import org.example.msbanqueapplication.repository.CompteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {

    @Autowired
    private CompteRepository compteRepository;

    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Compte> getComptes() {
        return compteRepository.findAll();
    }
    // READ: Récupérer un compte par son identifiant
    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType. APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte getCompte (@PathParam("id") Long id) {
        return compteRepository.findById(id).orElse(null);
    }
    // CREATE: Ajouter un nouveau compte
    @Path("/comptes")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte addCompte (Compte compte) {
        return compteRepository.save(compte);}

    @Path("/comptes/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Compte updateCompte(@PathParam("id") Long id, Compte compte) {
        Compte existingCompte = compteRepository.findById(id).orElse(null) ;
        if (existingCompte != null) {
            existingCompte.setSolde(compte.getSolde());
            existingCompte.setDateCreation(compte.getDateCreation());
            existingCompte.setType(compte.getType());
            return compteRepository.save(existingCompte);}

        return null;}
    // DELETE: Supprimer un compte
    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteCompte(@PathParam("id") Long id) {
        compteRepository.deleteById(id) ;
    }
}
