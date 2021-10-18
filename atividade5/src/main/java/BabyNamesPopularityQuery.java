import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Consulta a base de dados.
 */
public class BabyNamesPopularityQuery {

    /**
     * Retorna o rank.
     * @param ano ano de consulta.
     * @param genero genero de consulta.
     * @param nome nome de consulta.
     * @return posicao do rank.
     * @throws YearNotFoundException ano invalido
     * @throws GenderNotFoundException genero invalido
     * @throws NameNotFoundException nome invalido
     */
    public int getRank(int ano, char genero, String nome)
        throws YearNotFoundException, GenderNotFoundException, NameNotFoundException {
        int posicao = 0;
        if (ano < 2001 || ano > 2010) {
            throw new YearNotFoundException(ano);
        }
        if (genero != 'f' && genero != 'm' && genero != 'M' && genero != 'F') {
            throw new GenderNotFoundException(genero);
        }

        File file = new File("data/babynames/ranking" + ano + ".csv");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                posicao = Integer.parseInt(scanner.next());
                if (genero == 'm' || genero == 'M') {
                    if (nome.equals(scanner.next())) {
                        return posicao;
                    }
                    scanner.next();
                    scanner.next();
                    scanner.next();
                } else {
                    scanner.next();
                    scanner.next();
                    if (nome.equals(scanner.next())) {
                        return posicao;
                    }
                    scanner.next();
                }
            }
            if (posicao == 1000) {
                throw new NameNotFoundException(nome);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not scan the file");
            e.printStackTrace();
        }
        return posicao;
    }

    /**
     * Retorna a quantidade de pessoas com o nome e genero.
     * @param ano ano de consulta
     * @param genero genero de consulta
     * @param nome nome de consulta
     * @return Count
     * @throws YearNotFoundException ano invalido
     * @throws GenderNotFoundException genero invalido
     * @throws NameNotFoundException nome invalido
     */
    public int getCount(int ano, char genero, String nome)
        throws YearNotFoundException, GenderNotFoundException, NameNotFoundException {
        if (ano < 2001 || ano > 2010) {
            throw new YearNotFoundException(ano);
        }
        if (genero != 'f' && genero != 'm' && genero != 'M' && genero != 'F') {
            throw new GenderNotFoundException(genero);
        }
        File file = new File("data/babynames/ranking" + ano + ".csv");
        int posicao = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                scanner.next();
                if (genero == 'm' || genero == 'M') {
                    if (nome.equals(scanner.next())) {
                        posicao = Integer.parseInt(scanner.next());
                        return posicao;
                    }
                    scanner.next();
                    scanner.next();
                    scanner.next();
                } else {
                    scanner.next();
                    scanner.next();
                    if (nome.equals(scanner.next())) {
                        posicao = Integer.parseInt(scanner.next());
                        return posicao;
                    }
                    scanner.next();
                }
            }
            throw new NameNotFoundException(nome);
        } catch (FileNotFoundException e) {
            System.err.println("Could not scan the file");
            e.printStackTrace();
        }
        return posicao;
    }

    /**
     * Retorna o total de nascimentos por genero e ano.
     * @param ano ano de consulta
     * @param genero genero de consulta
     * @return total de nascimentos
     * @throws YearNotFoundException ano invalido
     * @throws GenderNotFoundException genero invalido
     */
    public int getTotal(int ano, char genero)
        throws YearNotFoundException, GenderNotFoundException {
        if (ano < 2001 || ano > 2010) {
            throw new YearNotFoundException(ano);
        }
        if (genero != 'f' && genero != 'm' && genero != 'M' && genero != 'F') {
            throw new GenderNotFoundException(genero);
        }
        int total = 0;
        File file = new File("data/babynames/ranking" + ano + ".csv");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                scanner.next();
                scanner.next();
                if (genero == 'm' || genero == 'M') {
                    total = total + Integer.parseInt(scanner.next());
                    scanner.next();
                    scanner.next();
                } else {
                    scanner.next();
                    scanner.next();
                    total = total + Integer.parseInt(scanner.next());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not scan the file");
            e.printStackTrace();
        }
        return total;
    }

    /**
     * ranking por genero.
     * @param k quantidade de posicoes
     * @param anos anos a serem buscados
     * @param genero generos a serem consultados
     * @return ranking de nomes
     * @throws YearNotFoundException ano invalido
     * @throws GenderNotFoundException genero invalido
     * @throws RankingOutOfBoundsException quantidade invalida
     */
    public NameRecord[][] getTopK(int k, int[] anos, char genero)
        throws YearNotFoundException, GenderNotFoundException, RankingOutOfBoundsException {
        if (genero != 'f' && genero != 'm' && genero != 'M' && genero != 'F') {
            throw new GenderNotFoundException(genero);
        }
        if (k > 1000 || k < 1) {
            throw new RankingOutOfBoundsException(k);
        }
        int i;
        int j;
        if (anos == null || anos.length == 0) {
            throw new YearNotFoundException(0);
        } else {
            for (i = 0; i < anos.length; i++) {
                if (anos[i] < 2001 || anos[i] > 2010) {
                    throw new YearNotFoundException(anos[i]);
                }
            }
        }

        NameRecord[][] topK = new NameRecord[anos.length][k];
        for (i = 0; i < anos.length; i++) {
            File file = new File("data/babynames/ranking" + anos[i] + ".csv");
            try (Scanner scanner = new Scanner(file)) {

                for (j = 0; j < k; j++) {
                    int rank = Integer.parseInt(scanner.next());
                    if (genero == 'm') {
                        topK[i][j] = new NameRecord(rank, scanner.next(),
                            Integer.parseInt(scanner.next()));
                        scanner.next();
                        scanner.next();
                    } else if (genero == 'f') {
                        scanner.next();
                        scanner.next();
                        topK[i][j] = new NameRecord(rank, scanner.next(),
                            Integer.parseInt(scanner.next()));
                    }
                }
            } catch (FileNotFoundException e) {
                System.err.println("Could not scan the file");
                e.printStackTrace();
            }
        }

        return topK;
    }

    /**
     * Exporta nomes por ano e genero.
     * @param ano ano a consultar
     * @param genero genero a consultar
     * @param caminho onde sera salvo
     * @throws YearNotFoundException ano invalido
     * @throws GenderNotFoundException genero invalido
     * @throws java.io.IOException nao salvou o arquivo
     */
    public void export(int ano, char genero, String caminho)
        throws YearNotFoundException, GenderNotFoundException, java.io.IOException {
        if (ano < 2001 || ano > 2010) {
            throw new YearNotFoundException(ano);
        }
        if (genero != 'f' && genero != 'm' && genero != 'M' && genero != 'F') {
            throw new GenderNotFoundException(genero);
        }
        File leitura = new File("data/babynames/ranking" + ano + ".csv");
        File file = new File(caminho);

        try (Scanner scanner = new Scanner(leitura); PrintWriter pw = new PrintWriter(file)) {
            String format = "%d,%s,%d\n";
            while (scanner.hasNext()) {
                if (genero == 'm' || genero == 'M') {
                    pw.printf(format, Integer.parseInt(scanner.next()), scanner.next(),
                        Integer.parseInt(scanner.next()));
                    scanner.next();
                    scanner.next();
                } else {
                    int rank = Integer.parseInt(scanner.next());
                    scanner.next();
                    scanner.next();
                    pw.printf(format, rank, scanner.next(), Integer.parseInt(scanner.next()));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Failed to create the file");
            e.printStackTrace();
        }
        if (!file.exists()) {
            throw new java.io.IOException();
        }
    }
}
