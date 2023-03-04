package com.eflores.StreamingPlatform.service.implementation;

import java.util.Collection;

import static org.springframework.data.domain.PageRequest.of;
import org.springframework.stereotype.Service;

import com.eflores.StreamingPlatform.model.Pago;
import com.eflores.StreamingPlatform.repo.PagoRepo;
import com.eflores.StreamingPlatform.service.PagoService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PagoServiceImplementation implements PagoService{

    private final PagoRepo pagoRepo;

    /**
     * Crea un pago en la Base de Datos.
     * 
     * @param pago el pago a agregar
     * @return el pago agregado
     */
    @Override
    public Pago crear(Pago pago) {
        log.info("Creando nuevo pago: {}",pago.getId());
        return pagoRepo.save(pago);
    }


    /**
     * Lista todos los pagos de la Base de Datos.
     * 
     * @return todos los pagos de la Base de Datos
     */
    @Override
    public Collection<Pago> listAll(int limit) {
        log.info("Obteniendo todos los ultimos {} pagos...", limit);
        return pagoRepo.findAll(of(0, limit)).toList();
    }

    /**
     * Modifica un pago en la Base de Datos.
     * 
     * @param pago el pago a modificar
     * @return el pago modificado
     */
    @Override
    public Pago modificar(Pago pago) {
        log.info("Modificando pago: {}",pago.getId());
        return pagoRepo.save(pago);
    }


    /**
     * Consulta un pago de la Base de Datos.
     * 
     * @param id el id del pago deseado
     * @return el pago consultado
     */
    @Override
    public Pago get(Long id) {
        log.info("Consultando pago por id: {}",id);
        return pagoRepo.findById(id).get();
    }

    /**
     * Elimina un pago en la Base de Datos.
     * 
     * @param id el id del pago a eliminar
     * @return verdadero si la funcion fue exitosa, falso si hubo un error
     */
    @Override
    public Boolean eliminar(Long id) {
        log.info("Eliminando pago por id: {}",id);
        pagoRepo.deleteById(id);
        return Boolean.TRUE;
    }
}
