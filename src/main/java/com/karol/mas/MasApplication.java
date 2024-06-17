package com.karol.mas;

import com.karol.mas.entity.WyposazenieTeatru;
import com.karol.mas.service.WyposazenieTeatruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@ComponentScan(basePackages = {"com.karol.mas.context", "com.karol.mas.controller", "com.karol.mas.service"})

public class MasApplication{

//    private final WyposazenieTeatruServiceImp wyposazenieTeatruServiceImp;

//    @Autowired
//    public MasApplication(WyposazenieTeatruServiceImp wyposazenieTeatruServiceImp)
//    {
//        this.wyposazenieTeatruServiceImp = wyposazenieTeatruServiceImp;
//    }

//    private static final Logger log = LoggerFactory.getLogger(MasApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MasApplication.class, args);
    }

//    private WyposazenieTeatruService wyposazenieTeatruService = new WyposazenieTeatruServiceImp();
//    @Autowired
//    private WyposazenieTeatruService wyposazenieTeatruService;

    @Autowired
    private WyposazenieTeatruService wyposazenieTeatruService;
    @GetMapping("/hello")
    public String addWyposazenieTeatru()
    {
        WyposazenieTeatru wyposazenieTeatru = new WyposazenieTeatru();
        wyposazenieTeatru.setNazwa("123");
        wyposazenieTeatru.setIdentyfikator_magazynowy("ID1");
        wyposazenieTeatru.setOpis("XDDD");
        System.out.println(wyposazenieTeatru.getIdentyfikator_magazynowy());
        wyposazenieTeatruService.addWyposazenieTeatru(wyposazenieTeatru);
        return "OK";
    }



    /**
    public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory)
    {
        return new HibernateTemplate(sessionFactory);
    }

    public SessionFactory sessionFactory()
    {
        SessionFactoryBuilder sfb = metadata().getSessionFactoryBuilder();
        return sfb.build();


    }



    public StandardServiceRegistry standardServiceRegistry()
    {
        return new StandardServiceRegistryBuilder().build();
    }

    MetadataSources sources()
    {
        return new MetadataSources(standardServiceRegistry());
    }

    Metadata metadata()
    {
        MetadataSources sources = sources();
        MetadataBuilder metadataBuilder = sources.getMetadataBuilder();
        metadataBuilder.applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE);
        metadataBuilder.applyImplicitSchemaName("MAS");
        return metadataBuilder.build();
    }

    @GetMapping("/XD")
    String xd() {
        return "XD";
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
*/

//    @Override
//    public void run(String... strings) throws Exception {
//        try {
//            ClassPathResource resource = new ClassPathResource("TheaterDatabase_create.sql");
//            String dbBuilder = Files.readString(Paths.get(resource.getURI()));
//            log.info("Creating tables");
////            jdbcTemplate.execute(dbBuilder);
//        } catch (Exception e) {
//            System.out.println("Thing's went south.");
//        }
//
//
//    }
}
