package tn.esprit.rh.achat;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplTest {
@Mock
ProduitRepository produitRepository;
@InjectMocks
ProduitServiceImpl produitService;
Produit p1=new Produit(12L,"123","prod1",(float)1200,null,null,null,null,null);
List<Produit> listProduits=new ArrayList<Produit>(){
	{
	add(new Produit(13L,"123","prod2",(float)1200,null,null,null,null,null));
	add(new Produit(14L,"123","prod3",(float)1200,null,null,null,null,null));
	}
	
};
@Test
@Order(1)
public void testRetrieveProduit() {
   System.out.println("Mock1 TestRetrieveProduit");
    Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(p1));
    Produit produit1 = produitService.retrieveProduit(Long.valueOf("1"));
    Assertions.assertNotNull(produit1);
}

}
