class Car:
    def __init__(self, day: str, time: str, licenseplate: str, cid: str, km: str, out: int):
        self.day: int = int(day)
        self.time: str = time
        self.licenseplate: str = licenseplate
        self.cid: str = cid
        self.km: int = int(km)
        self.out: bool = bool(out)


    def strout(self) -> str:
        return "ki" if self.out else "be"
