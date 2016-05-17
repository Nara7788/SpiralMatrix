import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClass
{
    private static int width;
    private static int height;
    private static int x;
    private static int y;
    private static int[][] matrix;
    private static int counter = 1;
    private static LastPos lastPos;


    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Введите ширину матрицы: ");
        x = Integer.parseInt(reader.readLine());
        System.out.print("Введите высоту матрицы: ");
        y = Integer.parseInt(reader.readLine());
        reader.close();

        width = x;
        height = y;

        matrix = new int[height][width];
        lastPos = new LastPos(0, 0);

        while (true)
        {
            moveRight();
            if (counter == x*y) break;
            moveDown();
            if (counter == x*y) break;
            moveLeft();
            if (counter == x*y) break;
            moveUp();
            if (counter == x*y) break;
        }
        print();
    }

    public static void print()
    {
        for (int i = 0; i < y; i++)
        {
            for (int j = 0; j < x; j++)
            {
                //for nice displaying set the different indents for different number of ordinals
                if (matrix[i][j] < 10)
                    System.out.print("[ " + matrix[i][j] + " ]");
                else if (matrix[i][j] > 9 && matrix[i][j] < 100)
                    System.out.print("[" + matrix[i][j] + " ]");
                else
                    System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static void moveRight()
    {
        if (counter == 1)
        {
            for (int w = lastPos.getWi(); w < lastPos.getWi() + width; w++)
            {
                matrix[lastPos.getHe()][w] = counter;
                counter++;
            }
            counter--;
            lastPos.setWi(lastPos.getWi() + width - 1);

        } else
        {
            for (int w = lastPos.getWi(); w < lastPos.getWi() + width; w++)
            {
                matrix[lastPos.getHe()][w] = counter;
                counter++;
            }
            width--;
            lastPos.setWi(lastPos.getWi() + width);

            counter--;
        }
    }

    public static void moveDown()
    {
        for (int h = lastPos.getHe(); h < lastPos.getHe() + height; h++)
        {
            matrix[h][lastPos.getWi()] = counter;
            counter++;
        }
        height--;
        lastPos.setHe(lastPos.getHe() + height);

        counter--;
    }

    public static void moveLeft()
    {
        for (int w = lastPos.getWi(); w >= lastPos.getWi() - width + 1; w--)
        {
            matrix[lastPos.getHe()][w] = counter;
            counter++;

        }
        width--;
        lastPos.setWi(lastPos.getWi() - width);
        counter--;
    }

    public static void moveUp()
    {
        for (int h = lastPos.getHe(); h >= lastPos.getHe() - height + 1; h--)
        {
            matrix[h][lastPos.getWi()] = counter;
            counter++;
        }
        lastPos.setHe(lastPos.getHe() - height + 1);
        height--;
        counter--;
    }

    static class LastPos
    {
        int wi;
        int he;

        public LastPos(int width, int heigh)
        {
            this.wi = width;
            this.he = heigh;
        }

        public int getWi()
        {
            return wi;
        }

        public int getHe()
        {
            return he;
        }

        public void setWi(int wi)

        {
            this.wi = wi;
        }

        public void setHe(int he)
        {
            this.he = he;
        }
    }
}
