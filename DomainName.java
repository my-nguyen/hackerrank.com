import java.util.*;

class DomainName {
    static void printDomains(String[] arr) {
        Set<String> domains = new HashSet<>();
        for (String line : arr) {
            if (line.contains("http://")) {
                int index = line.indexOf("http://");
                String substring = line.substring(index+7);
                String domain = substring.split("/")[0];
                if (domain.contains("www.") || domain.contains("ww2.") || domain.contains("web.")) {
                    System.out.print("before: " + domain);
                    domain = domain.substring(4);
                    System.out.println(", after: " + domain);
                }
                System.out.println("adding domain: " + domain);
                domains.add(domain);
            }
        }
        // Collections.sort(domains);
        StringBuilder builder = new StringBuilder();
        Iterator it = domains.iterator();
        while (it.hasNext()) {
            builder.append(it.next() + ";");
        }
        builder.setLength(builder.length() - 1);
        System.out.println(builder);
        /*
        System.out.print(domains.get(0));
        for (int i = 1; i < domains.size(); i++)
            System.out.print(";" + domains.get(i));
        System.out.println();
        */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        printDomains(lines.toArray(new String[lines.size()]));
    }
}
