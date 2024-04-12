class solution(object):
    def median(self,nums1,nums2):
        nums=sorted(nums1+nums2)
        n=len(nums)
        if n%2==0:
            return(nums[n//2-1]+nums[n//2])/2.0
        else:
            return nums[n//2]

S=solution()
nums1 = [int(num) for num in input(" ").split(",")]
nums2 = [int(num) for num in input(" ").split(",")]
print("The median is: ",S.median(nums1,nums2))
