package br.com.fiap.challenge.controller;

import br.com.fiap.challenge.model.Ias;
import br.com.fiap.challenge.DTO.IasDTO;
import br.com.fiap.challenge.DTO.IasResponseDTO;
import br.com.fiap.challenge.service.IasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ia")
public class IasControllerv1 {

    @Autowired
    IasService iasService;

    @GetMapping
    public ResponseEntity<List<IasResponseDTO>> requestIas(){

        return ResponseEntity.ok(iasService.listAll());
    }

    @PostMapping
    public ResponseEntity<Ias> createIa(@RequestBody IasDTO ia){
        return ResponseEntity.ok(iasService.createIa(ia));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIa(@PathVariable String id) {
        iasService.deleteIa(id);
        return ResponseEntity.ok("Usuário com o id " + id + " deletado com sucesso!");
    }

    @PutMapping
    public ResponseEntity<Ias> updateIa(@RequestBody Ias ia) {
        return ResponseEntity.ok(iasService.putIa(ia));
    }
}
