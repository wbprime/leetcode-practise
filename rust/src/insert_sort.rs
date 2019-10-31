use crate::sort::Sort;

pub struct InsertSort {}

impl InsertSort {
    pub fn new() -> InsertSort {
        InsertSort {}
    }
}

fn swap(_data: &mut [i32], i: usize, j: usize) {
    let tmp = _data[i];
    _data[i] = _data[j];
    _data[j] = tmp;
}

impl Sort for InsertSort {
    fn sort(&self, _data: &mut [i32]) {
        let n = _data.len();

        for i in 1..n {
            for j in (0..i).rev() {
                if _data[j+1] >= _data[j] {
                    break;
                }
                swap(_data, j+1, j);
            }
        }
    }
}

#[cfg(test)]
mod test {
    use ::rand::prelude::*;
    use super::InsertSort;
    use crate::sort::Sort;

    #[test]
    fn sort() {
        let mut rng = rand::thread_rng();
        let mut data: Vec<i32> = (1..100).collect();
        data.shuffle(&mut rng);

        let sorting = InsertSort::new();

        println!("Before sorting: {:?}", data);
        sorting.sort(&mut data);
        println!("After sorting: {:?}", data);
    }
}
