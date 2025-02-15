package com.mddw.readers.THE_READERS.model;

import com.mddw.readers.THE_READERS.repository.BookRepository;
import com.mddw.readers.THE_READERS.repository.CategoryRepository;
import com.mddw.readers.THE_READERS.repository.PublisherRepository;
import com.mddw.readers.THE_READERS.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer {

    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PublisherRepository publisherRepository;
    private final CategoryRepository categoryRepository;

    public DataInitializer(BookRepository bookRepository,
                           UserRepository userRepository,
                            PublisherRepository publisherRepository,
                            CategoryRepository categoryRepository,
                           PasswordEncoder passwordEncoder) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.publisherRepository = publisherRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    public void init() {
        Publisher crisol = new Publisher();
        crisol.setName("Crisol");
        publisherRepository.save(crisol);

        Publisher ibero = new Publisher();
        ibero.setName("Ibero");
        publisherRepository.save(ibero);

        Category infantil = new Category();
        infantil.setName("Infantil");
        categoryRepository.save(infantil);

        Category juvenil = new Category();
        juvenil.setName("Juvenil");
        categoryRepository.save(juvenil);


        if (bookRepository.count() == 0) {
            List<Book> books = Arrays.asList(
                    new Book(1, "DIARIO DE GREG 1 (TD). UN RENACUAJO",
                            "En primer lugar, quiero dejar una cosa bien clara: esto no es un diario. Ya sé lo que pone en la portada. Mira que cuando Mamá lo fue a comprar le pedí DE MANERA ESPECÍFICA que si compraba una libreta no tuviera el rotulito de diario». Greg Heffley tiene 12 años y su madre le compra un diario que abarcará un curso escolar: de septiembre a junio.",
                            "https://www.sbs.com.pe/media/catalog/product/9/7/9786125054005.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=914&width=700&canvas=700:914",
                            69,
                            juvenil,
                            crisol),
                    new Book(2,
                            "DIARIO DE GREG 2 (TD). LA LEY DE RODRICK",
                            "Mejor no preguntarle a Greg qué tal lo ha pasado durante las vacaciones de verano, porque no quiere ni oír hablar del asunto. De hecho, al empezar el nuevo curso Greg está deseando olvidar los últimos tres meses de su vida, en particular cierto acontecimiento... Por desgracia para él, su hermano Rodrick lo sabe todo sobre ese incidente que él querría enterrar para siempre. Y es que todos los secretos acaban saliendo a la luz... sobre todo cuando hay un diario de por medio.",
                            "https://www.sbs.com.pe/media/catalog/product/9/7/9786125054012_1.jpeg?quality=80&bg-color=255,255,255&fit=bounds&height=914&width=700&canvas=700:914",
                            69,
                            juvenil,
                            crisol),
                    new Book(3,
                            "DIARIO DE GREG 3 (TD). ¡ESTO ES EL COLMO",
                            "Seamos realistas: Greg Heffley nunca va a dejar de ser un pringao y alguien debería explicárselo a su padre. Resulta que Frank Heffley cree que su hijo puede cambiar. Y para endurecerlo, ha apuntado a Greg a todo tipo de deportes de competición y otras lindezas por el estilo. Claro que para Greg es pan comido dar al traste con los esfuerzos paternos por reformarlo. Sin embargo, cuando su padre amenaza con enviarlo a una academia militar, se da cuenta de que va a tener que ponerse las pilas.",
                            "https://www.sbs.com.pe/media/catalog/product/9/7/9786125054029_1.jpeg?quality=80&bg-color=255,255,255&fit=bounds&height=914&width=700&canvas=700:914",
                            59,
                            juvenil,
                            ibero),
                    new Book(4,
                            "DIARIO DE GREG 4 (TD). DIAS DE PERROS",
                            "Son las vacaciones de verano, hace un tiempo fabuloso y todo el personal se lo pasa en grande al aire libre. ¿Y dónde está Greg Heffley? Encerrado en casa, con las cortinas echadas, jugando con la consola. Greg está viviendo sus vacaciones soñadas: sin obligaciones ni normas. Para su madre, sin embargo, el verano ideal es algo muy diferente... más relacionado con actividades al aire libre y «convivencia familiar». ¿Cuál de las dos visiones se impondrá? ¿Es posible que un nuevo fichaje lo cambie todo en la familia Heffley?",
                            "https://www.sbs.com.pe/media/catalog/product/9/7/9786125054036_1.jpeg?quality=80&bg-color=255,255,255&fit=bounds&height=914&width=700&canvas=700:914",
                            59,
                            juvenil,
                            ibero),
                    new Book(5,
                            "DIARIO DE GREG 5 (TD). LA CRUDA REALIDAD",
                            "Greg Heffley siempre ha tenido prisa por crecer. Pero, ahora que empieza a hacerse mayor, ¿de veras resulta todo tan divertido? De pronto Greg se descubre a sí mismo inmerso en la tensión de las fiestas de los chicos y chicas, tiene mayores responsabilidades y sufre los cambios fisiológicos propios de la edad. Todo ello sin poder contar con su inseparable mejor amigo, Rowley. ¿Podrá Greg salir adelante por sus propios medios? ¿O tendrá que rendirse ante «LA CRUDA REALIDAD»?",
                            "https://www.sbs.com.pe/media/catalog/product/9/7/9786125054043_1.jpeg?quality=80&bg-color=255,255,255&fit=bounds&height=914&width=700&canvas=700:914",
                            69,
                            infantil,
                            crisol),
                    new Book(6,
                            "DIARIO DE GREG 6 (TD). ¡SIN SALIDA!",
                            "Greg Heffley está en apuros. Alguien ha causado desperfectos en el cole, y Greg es el principal sospechoso. Aunque, por una vez, es inocente... o algo parecido. Parece que la policía anda tras la pista de Greg, pero una tormenta de nieve inesperada deja encerrada a la familia Heffley en casa. Greg sabe que cuando la nieve se derrita le tocará dar explicaciones, pero... ¿hay algún castigo peor que quedarse atrapado en casa con la familia en vacaciones?",
                            "https://www.sbs.com.pe/media/catalog/product/9/7/9786125054050_1.jpeg?quality=80&bg-color=255,255,255&fit=bounds&height=914&width=700&canvas=700:914",
                            69,
                            infantil,
                            ibero),
                    new Book(7,
                            "DIARIO DE GREG 7 (TD). SIN PAREJA",
                            "El amor está en el aire... ¿pero qué significa eso para Greg Heffley? La fiesta de San Valentín ha puesto el colegio de Greg patas arriba. ¡Incluso él se ha lanzado a buscar plan! Aunque enseguida ha empezado a preocuparse por si se queda solo en el frío de la «gran» noche... Su mejor amigo, Rowley, tampoco tiene planes, pero eso no es más que un consuelo de pringao. Una sorpresa inesperada hará que Greg consiga acompañante para el baile y dejará a Rowley como el tercero en discordia. Sin embargo, en una noche tan especial, puede pasar de todo, y al final, nunca se sabe quién acabará siendo afortunado en el amor.",
                            "https://www.sbs.com.pe/media/catalog/product/9/7/9786125054067_1.jpeg?quality=80&bg-color=255,255,255&fit=bounds&height=914&width=700&canvas=700:914",
                            59,
                            infantil,
                            ibero),
                    new Book(8,
                            "DIARIO DE GREG 8 (TD). MALA SUERTE",
                            "Greg Heffley está atravesando por una mala racha. Su mejor amigo, Rowley Jefferson, pasa de él desde que se ha echado novia. La cosa está tan mal que hasta Manny, su hermano pequeño, tiene más amigos que él... Sin embargo, Greg no piensa rendirse y está dispuesto a todo con tal de convertirse, de una vez por todas, en el tío más popular del colegio. ¿Conseguirá librarse de la mala suerte que le persigue?",
                            "https://www.sbs.com.pe/media/catalog/product/9/7/9786125054074_1.jpeg?quality=80&bg-color=255,255,255&fit=bounds&height=914&width=700&canvas=700:914",
                            59,
                            infantil,
                            crisol)


            );
            try {
                bookRepository.saveAll(books);
                logger.info("Books initialized successfully");
            } catch (Exception e) {
                logger.error("Error initializing books", e);
            }

            if (!userRepository.existsByEmail("admin@admin.com")) {
                User adminUser = new User();
                adminUser.setEmail("admin@admin.com");
                adminUser.setPassword(passwordEncoder.encode("admin"));
                adminUser.setName("Admin");
                adminUser.setLastName("Admin");
                adminUser.setUsername("admin");
                adminUser.setNumber(666666);
                adminUser.setGender("OTHER");

                try {
                    userRepository.save(adminUser);
                    logger.info("Admin user created successfully");
                } catch (ConstraintViolationException e) {
                    logger.error("Validation error while creating admin user:");
                    e.getConstraintViolations().forEach(violation ->
                            logger.error("{}: {}", violation.getPropertyPath(), violation.getMessage())
                    );
                } catch (Exception e) {
                    logger.error("Error creating admin user", e);
                }
            }
        }

    }

    }
