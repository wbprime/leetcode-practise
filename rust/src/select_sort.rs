use crate::sort::Sort;

pub struct SelectSort {

}

impl SelectSort {
    pub fn new() -> SelectSort {
        SelectSort {}
    }
}

impl Sort for SelectSort {
    fn sort(&self, _data: &mut [i32]) {
        let n = _data.len();

        for i in 0..(n-1) {
            let mut max_idx = 0;
            for j in 1..(n-i) {
                if _data[j] > _data[max_idx] {
                    max_idx = j;
                }
            }
            let tmp = _data[n-i-1];
            _data[n-i-1] = _data[max_idx];
            _data[max_idx] = tmp;
        }
    }
}
