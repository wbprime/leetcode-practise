use crate::sort::Sort;

pub struct BubbleSort {

}

impl BubbleSort {
    pub fn new() -> BubbleSort {
        BubbleSort {}
    }
}

impl Sort for BubbleSort {
    fn sort(&self, _data: &mut [i32]) {
        let n = _data.len();

        for i in 1..n {
            for j in 0..(n-i) {
                if _data[j] > _data[j+1] {
                    let tmp = _data[j];
                    _data[j] = _data[j+1];
                    _data[j+1] = tmp;
                }
            }
        }
    }
}
