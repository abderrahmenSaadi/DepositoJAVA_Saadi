package facade;

public class ComputerFacade {

    private BIOS bios;

    private HardDisk hardDisk;

    private OperatingSystem os;

    public ComputerFacade() {

        bios = new BIOS();

        hardDisk = new HardDisk();

        os = new OperatingSystem();
    }

    public void turnComputer() {

        bios.initialize();

        hardDisk.load();

        os.start();

        System.out.println(
                "[MohamedOS] Boot successful!\n"
        );
    }
}