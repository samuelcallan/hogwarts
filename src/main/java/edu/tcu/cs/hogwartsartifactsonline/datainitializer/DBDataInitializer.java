package edu.tcu.cs.hogwartsartifactsonline.datainitializer;

import edu.tcu.cs.hogwartsartifactsonline.dao.ArtifactDao;
import edu.tcu.cs.hogwartsartifactsonline.dao.WizardDao;
import edu.tcu.cs.hogwartsartifactsonline.domain.Artifact;
import edu.tcu.cs.hogwartsartifactsonline.domain.Wizard;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataInitializer implements CommandLineRunner {
    private ArtifactDao artifactDao;
    private WizardDao wizardDao;

    public DBDataInitializer(ArtifactDao artifactDao) {
        this.artifactDao = artifactDao;
    }

    @Override
    public void run(String... args) throws Exception {
        Artifact a1 = new Artifact();
        a1.setId("1250808601736515584");
        a1.setName("Deluminator");
        a1.setDescription("A device invented by Albus Dumbledore");
        a1.setImageUrl("imageUrl");

        Artifact a2 = new Artifact();
        a2.setId("1250808601744904193");
        a2.setName("Invisibility Cloak");
        a2.setDescription("Makes you invisible");
        a2.setImageUrl("imageUrl");

        Artifact a3 = new Artifact();
        a3.setId("1250808601744904192");
        a3.setName("Elder Wand");
        a3.setDescription("Strongest Wand in the magic world");
        a3.setImageUrl("imageUrl");

        Artifact a4 = new Artifact();
        a4.setId("1250808601744904194");
        a4.setName("The Marauder's Map");
        a4.setDescription("Magical Map of Hogwarts");
        a4.setImageUrl("imageUrl");

        Artifact a5 = new Artifact();
        a5.setId("1250808601744904195");
        a5.setName("The Sword of Gryffindor");
        a5.setDescription("A goblin-made sword adorned with large rubies in the pommel.");
        a5.setImageUrl("imageUrl");

        Artifact a6 = new Artifact();
        a6.setId("1250808601744904196");
        a6.setName("Ressurection Stone");
        a6.setDescription("Allows the holder to bring back the deceased");
        a6.setImageUrl("imageUrl");

        Wizard w1 = new Wizard();
        w1.setName("Albus Dumbledore");
        w1.addArtifacts(a1);
        w1.addArtifacts(a3);

        Wizard w2 = new Wizard();
        w2.setName("Harry Potter");
        w2.addArtifacts(a2);
        w2.addArtifacts(a4);

        Wizard w3 = new Wizard();
        w3.setName("Neville Longbottom");
        w3.addArtifacts(a5);

        wizardDao.save(w1);
        wizardDao.save(w2);
        wizardDao.save(w3);

        artifactDao.save(a6);

    }
}
