def sorszam(month: int, day: int) -> int:
    months: dict[int] = {'6': 15,'7': 31,'8': 31}
    day_of: int = -1
    for i in range(6, month - 1):
        day_of += months[str(i)]
    return day_of + day + 1
