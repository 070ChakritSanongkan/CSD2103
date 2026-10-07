#include <cstdlib>

int f1(int n, int a[]) {
    int s = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            s = s + std::abs(a[i] - a[j]);
        }
    }
    return s;
}

int f2(int n, int a[]) {
    int s = 0;
    for (int i = 0; i < n; ++i) {
        if (a[i] > n) {
            for (int j = 0; j < i; ++j) {
                s = s + a[i] * a[j];
            }
        }
    }
    return s;
}

int f3(int n) {
    int s = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < i * i; ++j) {
            s = s + j;
        }
    }
    return s;
}

int f4(int n) {
    if (n > 1)
        return 1 + 2 * f4(n - 1);
    return 0;
}

int f5(int n) {
    if (n > 1)
        return 3 * f5(n / 2) + 1;
    return 0;
}

int f6(int n) {
    if (n > 1)
        return 3 * f6(n - 1) + 2 * f6(n - 2);
    return 1;
}

int f7(int n) {
    int s = 1;
    for (int i = 0; i < n; ++i)
        s = s + f7(i);
    return s;
}

int f8(int n, int a[]) {
    int s = 1;
    for (int i = 0; i < n; ++i)
        s = s + a[n - 1] * a[i] * f8(n - 1, a);
    return s;
}

int g1(int n, int a[]) {
    return a[n - 1] - a[0];
}

int g2(int n, int a[]) {
    int s = 0;
    for (int i = 0; i < n; ++i)
        s += a[i];
    return s * s;
}

int g3(int n, int a[]) {
    int s = 0;
    int sum = 0;
    for (int i = 0; i < n; ++i) {
        s += a[i] * sum;
        sum += a[i];
    }
    return s;
}

   
