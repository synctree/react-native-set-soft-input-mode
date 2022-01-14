declare module "react-native-set-soft-input-mode" {
  const SoftInputMode: {
    set: (value: number) => void;
    ADJUST_NOTHING: number;
    ADJUST_PAN: number;
    ADJUST_RESIZE: number;
    ADJUST_UNSPECIFIED: number;
    STATE_ALWAYS_HIDDEN: number;
    STATE_ALWAYS_VISIBLE: number;
  };
  export default SoftInputMode;
}
