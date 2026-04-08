package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class LessonData {

    public static List<Lesson> getAllLessons() {
        List<Lesson> list = new ArrayList<>();

        list.add(new Lesson(
                "Bài 1",
                "Giới thiệu Python cho Data Science",

                "- Hiểu tại sao Python được dùng trong Data Science.\n"
                        + "- Làm quen với các công cụ cơ bản.",

                "- Python và môi trường phát triển: Jupyter Notebook, VS Code, Google Colab.\n"
                        + "- Các thư viện: numpy, pandas, matplotlib, seaborn.\n"
                        + "- Kiểu dữ liệu: số, chuỗi, danh sách, tuple, dictionary.",

                "import numpy as np\n"
                        + "import pandas as pd\n\n"
                        + "# 1. Tạo mảng NumPy\n"
                        + "arr = np.array([1, 2, 3, 4, 5])\n"
                        + "print(\"Mảng NumPy:\", arr)\n\n"
                        + "# Thao tác với mảng\n"
                        + "print(\"Trung bình:\", np.mean(arr))\n"
                        + "print(\"Bình phương:\", arr**2)\n\n"
                        + "# 2. Tạo DataFrame Pandas\n"
                        + "data = {\n"
                        + "    'Tên': ['Alice', 'Bob', 'Charlie', 'David'],\n"
                        + "    'Tuổi': [25, 30, 35, 28],\n"
                        + "    'Giới_tính': ['Nữ', 'Nam', 'Nam', 'Nam']\n"
                        + "}\n"
                        + "df = pd.DataFrame(data)\n"
                        + "print(\"\\nDataFrame:\\n\", df)\n\n"
                        + "# Thêm cột điểm\n"
                        + "df['Điểm'] = [8.5, 7.0, 9.0, 6.5]\n"
                        + "print(\"\\nDataFrame sau khi thêm cột Điểm:\\n\", df)\n\n"
                        + "# Sắp xếp theo điểm giảm dần\n"
                        + "df_sorted = df.sort_values(by='Điểm', ascending=False)\n"
                        + "print(\"\\nDataFrame sắp xếp theo Điểm:\\n\", df_sorted)",
                R.drawable.c1_b1
        ));

        list.add(new Lesson(
                "Bài 2",
                "Làm việc với dữ liệu bằng Pandas",

                "- Biết cách thao tác dữ liệu dạng bảng.",

                "- Đọc/ghi dữ liệu: read_csv, to_csv.\n"
                        + "- Truy xuất dữ liệu: df['cột'], df.loc[], df.iloc[].\n"
                        + "- Lọc dữ liệu, tính toán mean(), sum(), describe().",

                "# Giả lập file CSV\n"
                        + "df.to_csv(\"lop_hoc.csv\", index=False)\n\n"
                        + "# Đọc dữ liệu từ CSV\n"
                        + "df = pd.read_csv(\"lop_hoc.csv\")\n"
                        + "print(\"5 dòng đầu:\\n\", df.head())\n\n"
                        + "# Truy xuất cột và tính thống kê\n"
                        + "print(\"Điểm trung bình lớp:\", df['Điểm'].mean())\n"
                        + "print(\"Tuổi trung bình:\", df['Tuổi'].mean())\n\n"
                        + "# Lọc học sinh có điểm > 7\n"
                        + "df_hoc_sinh_gioi = df[df['Điểm'] > 7]\n"
                        + "print(\"\\nHọc sinh có điểm > 7:\\n\", df_hoc_sinh_gioi)\n\n"
                        + "# Sử dụng loc và iloc\n"
                        + "print(\"\\nHọc sinh đầu tiên (loc):\\n\", df.loc[0])\n"
                        + "print(\"Học sinh đầu tiên (iloc):\\n\", df.iloc[0])",
                R.drawable.c1_b2
        ));

        list.add(new Lesson(
                "Bài 3",
                "Trực quan hóa dữ liệu với Matplotlib và Seaborn",

                "- Biết cách biểu diễn dữ liệu trực quan.",

                "- Biểu đồ: line, bar, histogram, scatter\n"
                        + "- Tuỳ chỉnh biểu đồ: màu sắc, nhãn, tiêu đề.\n"
                        + "- Biểu đồ nâng cao với Seaborn: boxplot, heatmap.",

                "import matplotlib.pyplot as plt\n"
                        + "import seaborn as sns\n\n"
                        + "# Histogram phân phối điểm\n"
                        + "plt.hist(df['Điểm'], bins=5, color='skyblue', edgecolor='black')\n"
                        + "plt.title(\"Phân phối điểm lớp\")\n"
                        + "plt.xlabel(\"Điểm\")\n"
                        + "plt.ylabel(\"Số học sinh\")\n"
                        + "plt.show()\n\n"
                        + "# Bar chart: số học sinh theo giới tính\n"
                        + "df['Giới_tính'].value_counts().plot(kind='bar', color=['pink','lightblue'])\n"
                        + "plt.title(\"Số học sinh theo Giới tính\")\n"
                        + "plt.show()\n\n"
                        + "# Boxplot với Seaborn\n"
                        + "sns.boxplot(x='Giới_tính', y='Điểm', data=df)\n"
                        + "plt.title(\"Điểm theo Giới tính\")\n"
                        + "plt.show()\n\n"
                        + "# Pairplot: mối quan hệ tuổi - điểm\n"
                        + "sns.pairplot(df, hue='Giới_tính')\n"
                        + "plt.show()",
                R.drawable.c1_b3
        ));

        list.add(new Lesson(
                "Bài 4",
                "Làm sạch dữ liệu",

                "- Xử lý dữ liệu thiếu và lỗi.",

                "- Kiểm tra dữ liệu thiếu: isna(), dropna(), fillna().\n"
                        + "- Loại bỏ dữ liệu trùng lặp: drop_duplicates().\n"
                        + "- Chuyển đổi kiểu dữ liệu: astype().",

                "import numpy as np\n"
                        + "import pandas as pd\n\n"
                        + "# Dữ liệu lớp học\n"
                        + "data = {\n"
                        + "    'Tên': ['Alice', 'Bob', 'Charlie', 'David'],\n"
                        + "    'Tuổi': [25, 30, 35, 28],\n"
                        + "    'Giới_tính': ['Nữ', 'Nam', 'Nam', 'Nam'],\n"
                        + "    'Điểm': [8.5, 7.0, 9.0, 6.5]\n"
                        + "}\n"
                        + "df = pd.DataFrame(data)\n\n"
                        + "# Thêm giá trị thiếu giả lập\n"
                        + "df.loc[1, 'Điểm'] = np.nan\n"
                        + "df.loc[2, 'Tuổi'] = np.nan\n\n"
                        + "# Thêm trùng lặp\n"
                        + "df = pd.concat([df, df.iloc[[0]]], ignore_index=True)\n\n"
                        + "print(\"Dữ liệu ban đầu:\\n\", df)\n\n"
                        + "# Kiểm tra giá trị thiếu\n"
                        + "print(\"\\nSố giá trị thiếu mỗi cột:\\n\", df.isna().sum())\n\n"
                        + "# Điền giá trị thiếu bằng trung bình\n"
                        + "df['Điểm'] = df['Điểm'].fillna(df['Điểm'].mean())\n"
                        + "df['Tuổi'] = df['Tuổi'].fillna(df['Tuổi'].mean())\n\n"
                        + "# Loại bỏ trùng lặp\n"
                        + "df.drop_duplicates(inplace=True)\n\n"
                        + "# Chuyển kiểu dữ liệu\n"
                        + "df['Tuổi'] = df['Tuổi'].astype(int)\n\n"
                        + "print(\"\\nDữ liệu sau làm sạch:\\n\", df)",
                R.drawable.c2_b1
        ));

        list.add(new Lesson(
                "Bài 5",
                "Biến đổi dữ liệu",

                "- Chuẩn bị dữ liệu cho Machine Learning.",

                "- Chuẩn hóa dữ liệu: Min-Max scaling, Standardization.\n"
                        + "- Mã hóa biến categorical: pd.get_dummies(), LabelEncoder.\n"
                        + "- Tạo biến mới: feature engineering.",

                "from sklearn.preprocessing import StandardScaler, LabelEncoder\n\n"
                        + "# Chuẩn hóa điểm\n"
                        + "scaler = StandardScaler()\n"
                        + "df['Điểm_scaled'] = scaler.fit_transform(df[['Điểm']])\n"
                        + "print(\"\\nĐiểm chuẩn hóa:\\n\", df[['Điểm', 'Điểm_scaled']])\n\n"
                        + "# Mã hóa giới tính\n"
                        + "le = LabelEncoder()\n"
                        + "df['Giới_tính_encoded'] = le.fit_transform(df['Giới_tính'])\n"
                        + "print(\"\\nGiới tính mã hóa:\\n\", df[['Giới_tính', 'Giới_tính_encoded']])\n\n"
                        + "# Feature Engineering: học sinh xuất sắc\n"
                        + "df['XuatSac'] = df['Điểm'] > 8\n"
                        + "print(\"\\nHọc sinh xuất sắc:\\n\", df[['Tên', 'Điểm', 'XuatSac']])",
                R.drawable.c2_b2
        ));

        list.add(new Lesson(
                "Bài 6",
                "EDA nâng cao",

                "- Phân tích mối quan hệ giữa các biến.",

                "- Thống kê mô tả nâng cao.\n"
                        + "- Kiểm tra tương quan: corr().\n"
                        + "- Biểu diễn mối quan hệ: pairplot, heatmap.",

                "import pandas as pd\n"
                        + "import seaborn as sns\n"
                        + "import matplotlib.pyplot as plt\n\n"
                        + "# Giả lập dữ liệu lớp học đã làm sạch\n"
                        + "data = {\n"
                        + "    'Tên': ['Alice', 'Bob', 'Charlie', 'David'],\n"
                        + "    'Tuổi': [25, 30, 35, 28],\n"
                        + "    'Giới_tính': ['Nữ', 'Nam', 'Nam', 'Nam'],\n"
                        + "    'Điểm': [8.5, 7.5, 9.0, 6.5],\n"
                        + "    'Giới_tính_encoded': [0,1,1,1]  # đã mã hóa\n"
                        + "}\n"
                        + "df = pd.DataFrame(data)\n\n"
                        + "# Thống kê mô tả nâng cao\n"
                        + "print(\"\\nThống kê mô tả:\\n\", df.describe())\n\n"
                        + "# -------------------------------\n"
                        + "# 1. Tính ma trận tương quan\n"
                        + "# Chỉ lấy các cột số\n"
                        + "numeric_cols = df.select_dtypes(include=['int64','float64'])\n"
                        + "corr = numeric_cols.corr()\n"
                        + "print(\"\\nMa trận tương quan (chỉ số):\\n\", corr)\n\n"
                        + "# Vẽ Heatmap\n"
                        + "plt.figure(figsize=(6,4))\n"
                        + "sns.heatmap(corr, annot=True, cmap='coolwarm')\n"
                        + "plt.title(\"Heatmap tương quan\")\n"
                        + "plt.show()\n\n"
                        + "# -------------------------------\n"
                        + "# 2. Pairplot: trực quan mối quan hệ giữa các biến\n"
                        + "# Hue = Giới_tính, Seaborn tự động bỏ cột string khác\n"
                        + "sns.pairplot(df, hue='Giới_tính', vars=['Tuổi','Điểm'])\n"
                        + "plt.suptitle(\"Pairplot tuổi và điểm theo giới tính\", y=1.02)\n"
                        + "plt.show()\n\n"
                        + "# -------------------------------\n"
                        + "# 3. Thống kê nâng cao\n"
                        + "# Trung bình, min, max, std theo giới tính\n"
                        + "grouped = df.groupby('Giới_tính')[['Tuổi','Điểm']].agg(['mean','min','max','std'])\n"
                        + "print(\"\\nThống kê theo Giới_tính:\\n\", grouped)\n\n"
                        + "# -------------------------------\n"
                        + "# 4. Biểu đồ boxplot phân tích phân phối điểm theo giới tính\n"
                        + "plt.figure(figsize=(6,4))\n"
                        + "sns.boxplot(x='Giới_tính', y='Điểm', data=df, palette=['pink','lightblue'])\n"
                        + "plt.title(\"Boxplot Điểm theo Giới_tính\")\n"
                        + "plt.show()",
                R.drawable.c2_b3
        ));

        list.add(new Lesson(
                "Bài 7",
                "Giới thiệu Machine Learning",

                "- Hiểu khái niệm Machine Learning.",

                "- Supervised vs Unsupervised Learning.\n"
                        + "- Ví dụ bài toán: dự đoán điểm, phân loại học sinh giỏi/kém.\n"
                        + "- Quy trình ML: thu thập → tiền xử lý → huấn luyện → đánh giá → triển khai.",

                "import pandas as pd\n"
                        + "from sklearn.model_selection import train_test_split\n"
                        + "from sklearn.linear_model import LinearRegression\n"
                        + "import matplotlib.pyplot as plt\n\n"
                        + "# Dữ liệu lớp học\n"
                        + "data = {\n"
                        + "    'Tên': ['Alice', 'Bob', 'Charlie', 'David'],\n"
                        + "    'Tuổi': [25, 30, 35, 28],\n"
                        + "    'Điểm': [8.5, 7.5, 9.0, 6.5]\n"
                        + "}\n"
                        + "df = pd.DataFrame(data)\n\n"
                        + "# Feature và target\n"
                        + "X = df[['Tuổi']]\n"
                        + "y = df['Điểm']\n\n"
                        + "# Chia dữ liệu train/test\n"
                        + "X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)\n\n"
                        + "# Huấn luyện Linear Regression\n"
                        + "model = LinearRegression()\n"
                        + "model.fit(X_train, y_train)\n\n"
                        + "# Dự đoán\n"
                        + "y_pred = model.predict(X_test)\n\n"
                        + "print(\"Điểm dự đoán:\", y_pred)\n"
                        + "print(\"Độ chính xác (R^2):\", model.score(X_test, y_test))\n\n"
                        + "# Vẽ trực quan: tuổi vs điểm\n"
                        + "plt.scatter(df['Tuổi'], df['Điểm'], color='blue', label='Thực tế')\n"
                        + "plt.plot(X_test, y_pred, color='red', label='Dự đoán')\n"
                        + "plt.xlabel('Tuổi')\n"
                        + "plt.ylabel('Điểm')\n"
                        + "plt.title(\"Linear Regression: Dự đoán điểm theo tuổi\")\n"
                        + "plt.legend()\n"
                        + "plt.show()",
                R.drawable.c3_b1
        ));

        list.add(new Lesson(
                "Bài 8",
                "Classification",

                "- Hiểu thuật toán phân loại.",

                "- KNN, Decision Tree, Logistic Regression.\n"
                        + "- Đánh giá mô hình: Accuracy, Confusion Matrix.",

                "from sklearn.tree import DecisionTreeClassifier, plot_tree\n"
                        + "from sklearn.metrics import accuracy_score, confusion_matrix\n"
                        + "from sklearn.model_selection import train_test_split\n"
                        + "import pandas as pd\n"
                        + "import matplotlib.pyplot as plt\n\n"
                        + "# Dữ liệu lớp học\n"
                        + "data = {\n"
                        + "    'Tên': ['Alice', 'Bob', 'Charlie', 'David'],\n"
                        + "    'Tuổi': [25, 30, 35, 28],\n"
                        + "    'Điểm': [8.5, 7.5, 9.0, 6.5]\n"
                        + "}\n"
                        + "df = pd.DataFrame(data)\n\n"
                        + "# Tạo nhãn Giỏi/Kém\n"
                        + "df['Giỏi'] = df['Điểm'] > 7  # True = Giỏi, False = Kém\n\n"
                        + "X = df[['Tuổi','Điểm']]\n"
                        + "y = df['Giỏi']\n\n"
                        + "# Chia dữ liệu\n"
                        + "X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)\n\n"
                        + "# Huấn luyện Decision Tree\n"
                        + "clf = DecisionTreeClassifier(random_state=42)\n"
                        + "clf.fit(X_train, y_train)\n\n"
                        + "# Dự đoán\n"
                        + "y_pred = clf.predict(X_test)\n\n"
                        + "print(\"Accuracy:\", accuracy_score(y_test, y_pred))\n"
                        + "print(\"Confusion Matrix:\\n\", confusion_matrix(y_test, y_pred))\n\n"
                        + "# Vẽ cây quyết định\n"
                        + "plt.figure(figsize=(10,12))\n"
                        + "plot_tree(clf, feature_names=['Tuổi','Điểm'], class_names=['Kém','Giỏi'], filled=True)\n"
                        + "plt.show()",
                R.drawable.c3_b2
        ));

        list.add(new Lesson(
                "Bài 9",
                "Clustering",

                "- Nhóm dữ liệu không cần nhãn.",

                "- K-Means clustering.\n"
                        + "- Xác định số lượng cluster tối ưu (Elbow method).\n"
                        + "- Trực quan hóa kết quả.",

                "from sklearn.cluster import KMeans\n"
                        + "import pandas as pd\n"
                        + "import matplotlib.pyplot as plt\n\n"
                        + "# Dữ liệu lớp học\n"
                        + "data = {\n"
                        + "    'Tên': ['Alice', 'Bob', 'Charlie', 'David'],\n"
                        + "    'Tuổi': [25, 30, 35, 28],\n"
                        + "    'Điểm': [8.5, 7.5, 9.0, 6.5]\n"
                        + "}\n"
                        + "df = pd.DataFrame(data)\n\n"
                        + "X = df[['Tuổi','Điểm']]\n\n"
                        + "# KMeans clustering\n"
                        + "kmeans = KMeans(n_clusters=2, random_state=42)\n"
                        + "df['Cluster'] = kmeans.fit_predict(X)\n\n"
                        + "print(\"\\nKết quả cluster:\\n\", df[['Tên','Tuổi','Điểm','Cluster']])\n\n"
                        + "# Trực quan hóa clustering\n"
                        + "plt.figure(figsize=(6,4))\n"
                        + "plt.scatter(df['Tuổi'], df['Điểm'], c=df['Cluster'], cmap='viridis', s=100)\n"
                        + "plt.xlabel('Tuổi')\n"
                        + "plt.ylabel('Điểm')\n"
                        + "plt.title('KMeans Clustering học sinh')\n"
                        + "plt.show()",
                R.drawable.c3_b3
        ));

        return list;
    }
    public static Lesson getLessonByIndex(int index) {
        List<Lesson> list = getAllLessons();

        if (index >= 0 && index < list.size()) {
            return list.get(index);
        }

        return null;
    }

    public static Lesson getNextLesson(int index) {

        List<Lesson> list = getAllLessons();

        if (index < list.size() - 1) {
            return list.get(index + 1);
        }

        return null;
    }

    public static Lesson getPreviousLesson(int index) {

        List<Lesson> list = getAllLessons();

        if (index > 0) {
            return list.get(index - 1);
        }

        return null;
    }

    public static int getLessonCount() {
        return getAllLessons().size();
    }
}
