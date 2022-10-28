package mx.edu.utez.examenu2.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mx.edu.utez.examenu2.model.BeanPerson;
import mx.edu.utez.examenu2.model.DaoPersonal;
import mx.edu.utez.examenu2.utils.Response;

import java.util.List;

@Path("/api/personal")
public class PersonalServices {

    @GET
    @Path("/")
    @@Produces(value = {"application/json"})
    public List<BeanPerson> getAll(){
        return new DaoPersonal().findAll();
    }


    @GET
    @Path("/{id}")
            @Produces({MediaType.APPLICATION_JSON})
    public Response<BeanPerson> getByid(@PathParam("id") Long id){
        return new DaoPersonal().findById(id);
    }


    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanPerson> save(BeanPerson person){
        return new DaoPersonal().save(person);
    }

    @POST
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response<BeanPerson> update(BeanPerson person){
        return new DaoPersonal().update(person);
    }

}
