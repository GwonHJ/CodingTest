#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Job {
public:
    int salary;

    Job() {
        salary = 0;
    }

    int get_salary() {
        return salary;
    }
};

class PartTimeJob : public Job {
private:
    int work_hour, pay_per_hour;

public:
    PartTimeJob(int work_hour, int pay_per_hour) {
        this->work_hour = work_hour;
        this->pay_per_hour = pay_per_hour;
    }

    int get_salary() {
        salary = work_hour * pay_per_hour;
        if(work_hour >= 40)
            salary += (pay_per_hour * 8);

        return salary;
    }
};

class SalesJob : public Job {
private:
    int sales_result, pay_per_sale;

public:
    SalesJob(int sales_result, int pay_per_sale) {
        this->sales_result = sales_result;
        this->pay_per_sale = pay_per_sale;
    }

    int get_salary() {
        if(sales_result > 20)
            salary = sales_result * pay_per_sale * 3;
        else if(sales_result > 10)
            salary = sales_result * pay_per_sale * 2;
        else
            salary = sales_result * pay_per_sale;

        return salary;
    }
};

int solution(vector<vector<int>> part_time_jobs, vector<vector<int>> sales_jobs) {
    int answer = 0;

    for(int i = 0; i < part_time_jobs.size(); i++) {
        PartTimeJob part_time_job(part_time_jobs[i][0], part_time_jobs[i][1]);
        answer += part_time_job.get_salary();
    }

    for(int i = 0; i < sales_jobs.size(); i++) {
        SalesJob sales_job(sales_jobs[i][0], sales_jobs[i][1]);
        answer += sales_job.get_salary();
    }

    return answer;
}

// 아래는 테스트케이스 출력을 해보기 위한 main 함수입니다.
int main() {
    vector<vector<int>> part_time_jobs = {{10, 5000}, {43, 6800}, {5, 12800}};
    vector<vector<int>> sales_jobs = {{3, 18000}, {12, 8500}};
    int ret = solution(part_time_jobs, sales_jobs);

    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    cout << "solution 함수의 반환 값은 " << ret << " 입니다." << endl;
}
