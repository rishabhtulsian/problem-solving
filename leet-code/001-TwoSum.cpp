#include <iostream>
#include <vector>
#include <map>
using namespace std;
using namespace std::chrono;

class Solution {
	map<int, vector<int> > numbers;

public:
    vector<int> twoSum(vector<int>& nums, int target) {
    	vector<int> indices;
    	map<int, vector<int> >::iterator it;
        for(int i = 0; i < nums.size(); i++) {
        	if(numbers.find(nums[i]) == numbers.end()) {
        		numbers.insert(std::pair<int,vector<int> >(nums[i], vector<int>()));
        	}
        	numbers.find(nums[i])->second.push_back(i);
        }

        for(int i = 0; i < nums.size(); i++) {
        	it = numbers.find(target - nums[i]);
        	if(it != numbers.end() && it->second.size() > 0) {
        		if(it->second[0] != i) {
	        		indices.push_back(i+1);
	        		indices.push_back(it->second[0]+1);
			        return indices;
        		}
        		if(it->second[0] == i && it->second.size() > 1) {
	        		indices.push_back(i+1);
	        		indices.push_back(it->second[1]+1);
			        return indices;
        		}
        	}
        }
        return indices;
    }
};

int main() {
	vector<int> nums;
	for(int i = 0; i <= 32044; i+=2) {
		nums.push_back(i);
	}
	time_point<high_resolution_clock> start_time = high_resolution_clock::now();
	Solution solution;
	vector<int> indices = solution.twoSum(nums, 0);
	cout << endl;
	time_point<high_resolution_clock> current_time = high_resolution_clock::now();
	duration<double> diff = current_time - start_time;
	cout << "Time: " << diff.count() << endl;
	cout << indices[0];
	cout << " ";
	cout << indices[1];
	cout << endl;
	return 0;
}
