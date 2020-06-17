package ProgrammerSkills;

/**
 0x55555555 = 0b0101_0101_0101_0101_0101_0101_0101_0101 (奇数位为1)
 0xaaaaaaaa = 0b1010_1010_1010_1010_1010_1010_1010_1010 (偶数位为1)

 */
public class Question5_7 {

    public int exchangeBits(int num) {
        int odd = num &  0x55555555;
        int even = num & 0xaaaaaaaa;

        odd = odd <<1;
        even = even >>>1;
        return odd | even;
    }
}
