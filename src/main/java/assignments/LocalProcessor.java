package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    protected StringBuilder processorVersion = new StringBuilder();
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList;

    public LocalProcessor() {
    }

    public LocalProcessor(String processorName, Long period, StringBuilder processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, LinkedList<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        // iterating the list
        stringArrayList = new LinkedList<>(stringList);
        stringArrayList.forEach(System.out::println);
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        // generating the full name of the processor
        StringBuilder processorName = new StringBuilder();
        stringList.forEach(processorName::append);
        return processorName.toString();
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
        // reading a full processor name
        informationScanner = null;
        try {
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                processorVersion.append(informationScanner.nextLine());
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
            System.out.println("Exception was processed. Program continues");
        } finally {
            if (informationScanner != null)
                informationScanner.close();
        }
    }
}
