package com.mproduits.mproduitsapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
public class MicroserviceProduitsApplication {
    /*

  INSERT INTO product (id, titre, description, image, prix) VALUES
(1, 'Ordinateur Portable', 'Un ordinateur portable performant', 'image1.jpg', 20000.00),
(2, 'Aspirateur Robot', 'Un robot pour nettoyer votre maison', 'image2.jpg', 5000.00),
(3, 'Table de Ping Pong', 'Pour jouer au ping pong', 'image3.jpg', 1000.00),
(4, 'Guitare', 'Une guitare acoustique', 'image4.jpg', 200.00),
(5, 'Fusée', 'Une fusée jouet', 'image5.jpg', 200.00),
(6, 'Chocolat', 'Une barre de chocolat', 'image6.jpg', 30.00),
(7, 'Vélo', 'Un vélo de montagne', 'image7.jpg', 2000.00),
(8, 'Imprimante', 'Une imprimante multifonction', 'image8.jpg', 450.00),
(9, 'Voiture', 'Une voiture de luxe', 'image9.jpg', 200000.00),
(10, 'Montre', 'Une montre élégante', 'image10.jpg', 300.00);
    SELECT * FROM PRODUCT ;
     */
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProduitsApplication.class, args);
    }

}

