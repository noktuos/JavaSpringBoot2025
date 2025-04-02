package com.alldata.JavaCourse2025.serviceImpl;/*
 * @created 11/03/2025
 * @project JavaCourse2025
 * @author Noktuos
 */

import com.alldata.JavaCourse2025.entities.Usuario;
import com.alldata.JavaCourse2025.repositories.UsuarioCriteriaRepository;
import com.alldata.JavaCourse2025.repositories.UsuarioRepository;
import com.alldata.functionalInterface.BinaryOperator;
import com.alldata.functionalInterface.Calculadora;
import com.alldata.functionalInterface.UnaryOperator;
import com.alldata.genericos.Caja;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioCriteriaRepository usuarioCriteriaRepository;
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioCriteriaRepository usuarioCriteriaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioCriteriaRepository = usuarioCriteriaRepository;
    }

    @PostConstruct
    public void inicializar(){

        Caja<String> cajaDeTexto = new Caja<>();
        cajaDeTexto.setObjeto("Esto es un generic");
        System.out.println(cajaDeTexto.getObjeto());

        Caja<Integer> cajaDeNumeros = new Caja<>();
        cajaDeNumeros.setObjeto(11);
        System.out.println(cajaDeNumeros.getObjeto());

        List<String> nombres = Arrays.asList("Ana","Juan","Pedro","Carlos");
        nombres.stream()
                        .filter(nombre -> nombre.startsWith("J"))
                                .forEach(System.out::println);
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6);
        List<Integer> cuadrados = numeros.stream()
                        .map(numero ->numero*numero)
                .collect(Collectors.toList());

        Consumer<String> imprimir = mensaje -> System.out.println(mensaje);
        imprimir.accept("Esto es una lambda");

        Calculadora suma = (numero1,numero2) -> numero1 + numero2;
        System.out.println("Suma: "+ suma.operar(5,3));

        Predicate<Integer> esPar = numero1 -> numero1 % 2 ==0;
        System.out.println(esPar.test(8));
        System.out.println(esPar.test(7));

        Function<String,Integer> longitud = cadena -> cadena.length();
        System.out.println(longitud.apply("Honda Mundo"));

        System.out.println("Inicio bifunction");

        BiFunction<Float,Integer,Boolean> mayor = (n1,n2) -> {
            return n1.equals(n2);
        };
        System.out.println(mayor.apply(0.4f,1));

        BiConsumer<Integer,Integer> addTwo = (x,y) -> System.out.println(x+y);
        addTwo.accept(1,5);

        UnaryOperator<Integer> duplicateVal = val -> val * 2;
        System.out.println(duplicateVal.apply(5));

        BinaryOperator<Integer> sumar = (n1,n2)-> n1+n2;
        System.out.println(sumar.apply(5,10));

        List<Integer> numeros2 = Arrays.asList(1,2,3,4,5,6,7);
        int sumaDeNumeros = numeros2.stream()
                        .reduce(0,(numero1,numero2) -> numero1+numero2);
        System.out.println(sumaDeNumeros);


        System.out.println("Usuarios inicializados");

    }
    public Usuario crearUsuario(Usuario usuario){
        System.out.println("saving : "+ usuario);
        try{
            usuarioRepository.save(usuario);

        }catch(Exception e){
            e.printStackTrace();
        }
        return usuario;
    }
    public Usuario saveUser (Usuario usuario){
        return usuarioRepository.saveAndFlush(usuario);
    }
    public List<Usuario> obtenerTodosLosUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerUsuarioPorId(Long id){
        return usuarioRepository.findById(id);

    }

    public Optional<Usuario> buscarPorEmail(String email){
        return usuarioRepository.findByCorreo(email);
    }

    public ResponseEntity<Usuario> actualizarUsuario(Long id, Usuario nuevoUsuario){
        return usuarioRepository.findById(id)
                .map(usuario -> {
                   usuario.setNombre(nuevoUsuario.getNombre());
                   usuario.setCorreo(nuevoUsuario.getCorreo());
                   usuarioRepository.save(usuario);
                   return ResponseEntity.ok(usuario);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Object> eliminarUsuario(Long id){
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuarioRepository.delete(usuario);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Usuario>> obtenerUsuarioPorNombreyEdad(String nombre, int edad){
        return ResponseEntity.ok(usuarioCriteriaRepository.buscarPorNombreYEdad(nombre,edad));
    }
}
